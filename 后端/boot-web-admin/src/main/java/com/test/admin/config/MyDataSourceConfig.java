//package com.test.admin.config;
//
//
//import com.alibaba.druid.pool.DruidDataSource;
//import com.alibaba.druid.support.http.StatViewServlet;
//import com.alibaba.druid.support.http.WebStatFilter;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.web.servlet.FilterRegistrationBean;
//import org.springframework.boot.web.servlet.ServletRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import javax.sql.DataSource;
//import java.sql.Array;
//import java.sql.SQLException;
//import java.util.Arrays;
//
//@Configuration
//public class MyDataSourceConfig {
//
//    @ConfigurationProperties("spring.datasource") //把组件的属性与配置文件中的绑定
//    @Bean
//    public DataSource dataSource() throws SQLException {
//
//        DruidDataSource druidDataSource = new DruidDataSource();
//
////        druidDataSource.setUrl();
////        druidDataSource.setUsername();
////        druidDataSource.setPassword();
//        druidDataSource.setFilters("stat,wall");//数据源加入监控功能，增加防火墙
////        druidDataSource.setMaxActive(10);
//        return druidDataSource;
//    }
//
//    /**
//     * 配置druid的监控页,设置账号密码
//     * @return
//     */
//    @Bean
//    public ServletRegistrationBean statViewSevlet(){
//        StatViewServlet statViewServlet = new StatViewServlet();
//        ServletRegistrationBean<StatViewServlet> registrationBean = new ServletRegistrationBean<>(statViewServlet, "/druid/*");
//
//        registrationBean.addInitParameter("loginUsername","admin");
//        registrationBean.addInitParameter("loginPassword","123456");
//        return registrationBean;
//    }
//
//    /**
//     * WebStatFilter用于采集web-jdbc关联监控的数据
//     */
//    @Bean
//    public FilterRegistrationBean webStatFilter(){
//
//        WebStatFilter webStatFilter = new WebStatFilter();
//        FilterRegistrationBean<WebStatFilter> filterFilterRegistrationBean = new FilterRegistrationBean<>(webStatFilter);
//        filterFilterRegistrationBean.setUrlPatterns(Arrays.asList("/*"));
//        filterFilterRegistrationBean.addInitParameter("exclusions","*.js,*.git,*.jpg,*.png,*.css,*.ico,/druid/*");
//
//        return filterFilterRegistrationBean;
//    }
//}
