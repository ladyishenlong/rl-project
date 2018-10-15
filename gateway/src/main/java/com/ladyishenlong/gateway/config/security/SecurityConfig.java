package com.ladyishenlong.gateway.config.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ladyishenlong.gateway.bean.login.LoginBean;
import com.ladyishenlong.gateway.test.TestBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.Http403ForbiddenEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Slf4j
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    private ObjectMapper objectMapper;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.formLogin()
                .and()
                .csrf()
                .disable()
                .exceptionHandling()
                .authenticationEntryPoint(new Http403ForbiddenEntryPoint())//没登录就抛出403异常
                .and()
                .authorizeRequests()

                .antMatchers("/login").permitAll()
                .antMatchers("/hello2").permitAll()
//                .authenticationEntryPoint(new Http401AuthenticationEntryPoint("not login"))

                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .successHandler(new AuthenticationSuccessHandler() {
                    @Override
                    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {


                        String username = httpServletRequest.getParameter("username");
                        String sessionId = httpServletRequest.getSession().getId();

                        log.error("登录成功----用户名："+username+"\n sessionId:"+sessionId);

                        LoginBean loginBean=new LoginBean();
                        loginBean.setMessage("登陆成功");
                        loginBean.setCode(1);
                        loginBean.setSessionId(sessionId);

                        //返回信息
                        responseDeal(httpServletResponse, loginBean);
                    }
                })
                .failureHandler(new AuthenticationFailureHandler() {
                    @Override
                    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
                        log.error("登录失败");
                    }
                });
    }


    /**
     * 登录或者登出的返回信息
     *
     * @param httpServletResponse
     * @param message
     */
    private void responseDeal(HttpServletResponse httpServletResponse, Object message) throws IOException {
        httpServletResponse.setCharacterEncoding("UTF-8");
        httpServletResponse.setContentType("application/json;charset=utf-8");
        PrintWriter writer = httpServletResponse.getWriter();
        writer.write(objectMapper.writeValueAsString(message));
        writer.close();
    }


    /**
     * 验证用户名和密码
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .passwordEncoder(new RLPassWordEncoder())
                .withUser("123")
                .password("123")
                .roles("ADMIN");
    }


}
