package com.yscf.trade.web.protocol.usermod.domain;

public class LoginRequest {
    private String username;
    private String userpass;
    private String smscode;
    private Boolean fromgate=false;

    public Boolean isFromgate() {
        return fromgate;
    }

    public void setFromgate(Boolean fromgate) {
        this.fromgate = fromgate;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpass() {
        return userpass;
    }

    public void setUserpass(String userpass) {
        this.userpass = userpass;
    }

    public String getSmscode() {
        return smscode;
    }

    public void setSmscode(String smscode) {
        this.smscode = smscode;
    }
}
