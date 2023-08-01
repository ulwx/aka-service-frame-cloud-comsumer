package com.yscf.trade.web.protocol.usermod.domain;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "GatewayLoginResponse", description = "登录响应")
public class GatewayLoginResponse {
    @Schema( description = "用户id")
    private String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
