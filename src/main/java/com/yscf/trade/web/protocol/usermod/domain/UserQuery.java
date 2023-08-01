package com.yscf.trade.web.protocol.usermod.domain;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "用户查询信息", name = "UserQuer")
public class UserQuery {
    @Schema(description = "用户姓名")
    private String userName;
    @Schema(description = "用户年龄")
    private String userAge;
    @Schema(description = "用户性别")
    private String userSex;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserAge() {
        return userAge;
    }

    public void setUserAge(String userAge) {
        this.userAge = userAge;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }
}
