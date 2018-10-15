package com.ladyishenlong.gateway.config.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class RLUserDetailsService implements UserDetailsService {


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        //在这里可以从数据库拿数据验证

        // 封装用户信息，并返回。参数分别是：用户名，密码，用户权限
        User user = new User(username, "123",
                AuthorityUtils
                        .commaSeparatedStringToAuthorityList("admin"));


        log.error("进来："+username);

        return user;

    }
}
