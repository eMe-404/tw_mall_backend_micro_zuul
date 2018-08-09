package com.tw.microservice.zuul.VO;

import lombok.Data;

@Data
public class User {
    private Long userId;
    private String username;
    private String password;
    private String fullname;
    private Authority authority;

}
