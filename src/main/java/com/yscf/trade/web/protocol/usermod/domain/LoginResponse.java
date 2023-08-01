package com.yscf.trade.web.protocol.usermod.domain;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "LoginResponse", description = "登录响应")
public class LoginResponse {

    @Schema( description = "token")
    private String token;
    @Schema( description = "用户id")
    private String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }


    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
