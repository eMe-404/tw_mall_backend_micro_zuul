package com.tw.microservice.zuul.securitydemo;

import com.tw.microservice.zuul.VO.User;
import com.tw.microservice.zuul.login.JwtUser;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class TwMallUserDetailService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        RestTemplate restTemplate = new RestTemplate();
        User user = restTemplate.getForObject(String.format("http://localhost:8081/users/%s",username), User.class);

        if (user == null) {
            throw new UsernameNotFoundException(String.format("%s dosen't exist!", username));
        } else {
            return new JwtUser(user);
        }
    }
}
