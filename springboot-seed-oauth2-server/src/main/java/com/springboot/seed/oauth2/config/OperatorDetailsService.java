package com.springboot.seed.oauth2.config;

import java.util.Arrays;
import java.util.List;

import com.springboot.seed.oauth2.operator.Operator;
import com.springboot.seed.oauth2.operator.OperatorQueryService;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class OperatorDetailsService implements UserDetailsService {
    private final OperatorQueryService operatorQueryService;

    public OperatorDetailsService(OperatorQueryService operatorQueryService) {
        this.operatorQueryService = operatorQueryService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Operator operator = operatorQueryService.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("用户名或密码错误"));
        List<GrantedAuthority> authoritySet = Arrays.asList(new SimpleGrantedAuthority("ROLE_USERS"));
        return new User(operator.getUsername(), operator.getPassword(), true, true, true, true, authoritySet);
    }
}
