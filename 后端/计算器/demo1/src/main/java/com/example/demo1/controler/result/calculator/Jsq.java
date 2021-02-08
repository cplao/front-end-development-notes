package com.example.demo1.controler.result.calculator;

import java.util.Stack;

public class Jsq {
    public Integer calculate(String suanshi) {
        Calculatormpl cal = new Calculatormpl();
        suanshi = new Jsq().qutou(suanshi);
        String a = suanshi;
        Stack<Integer> sz = new Stack<Integer>();
        Stack<Character> fh = new Stack<Character>();
        Integer qs = 0, num = 0, answer = 0;
        boolean fuhao = false;
        if (suanshi.charAt(0) == '-') {
            a = a.substring(1);
            fuhao = true;
        }


        for (int i = 0; i < a.length(); i++) {
            if (46 <= a.charAt(i) && a.charAt(i) < 59) {
                num = ((int) a.charAt(i) - 48) + num * 10;
            } else if (a.charAt(i) == '+' || a.charAt(i) == '/' || a.charAt(i) == '*' || a.charAt(i) == '-') {
                if (!fh.isEmpty() && (fh.peek() == '*' || fh.peek() == '/')) {
                    qs = sz.pop();
                    if (fh.peek() == '*') {
                        num = cal.mul(qs, num);
                    } else {
                        num = cal.div(qs, num);
                    }
                    fh.pop();
                }
                fh.push(a.charAt(i));
                if (fuhao == true) {
                    num = -num;
                    fuhao = false;
                }
                sz.push(num);
                num = 0;
            }

        }

        if (fh.peek() == '*' || fh.peek() == '/') {
            qs = sz.pop();
            if (fh.peek() == '*') {
                num = cal.mul(qs, num);
                fh.pop();
            } else {
                num = cal.div(qs, num);
                fh.pop();
            }
        }


        sz.push(num);

        sz = new Jsq().changedsz(sz);
        fh = new Jsq().changedfu(fh);


        answer = sz.peek();
        while ((!sz.isEmpty()) && (!fh.isEmpty())) {
            if (fh.peek() == '+') {
                answer = cal.add(sz.pop(), sz.pop());
            } else if (fh.peek() == '-') {
                answer = cal.sub(sz.pop(), sz.pop());
            } else if (fh.peek() == '*') {
                answer = cal.mul(sz.pop(), sz.pop());
            } else if (fh.peek() == '/') {
                answer = cal.div(sz.pop(), sz.pop());
            }
            fh.pop();

            if (!sz.isEmpty()) {
                sz.push(answer);
            }
        }


        return answer;


    }

    public Stack<Integer> changedsz(Stack<Integer> Stack) {
        Stack<Integer> sz = new Stack<Integer>();
        while (!Stack.isEmpty()) {
            sz.push(Stack.pop());
        }
        return sz;
    }

    public Stack<Character> changedfu(Stack<Character> Stack) {
        Stack<Character> sz = new Stack<Character>();
        while (!Stack.isEmpty()) {
            sz.push(Stack.pop());
        }
        return sz;
    }

    public String qutou(String sz) {
        while (true) {
            if (sz.charAt(0) == '\r' || sz.charAt(0) == '\t' || sz.charAt(0) == '\n') {
                sz = sz.substring(1);
            } else break;
        }
        return sz;
    }
}
