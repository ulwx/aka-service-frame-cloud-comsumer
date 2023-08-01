package com.yscf.trade.web;

import com.github.ulwx.aka.frame.UiFrameConstants;
import com.github.ulwx.aka.frame.process.ProtocolBuilder;
import com.github.ulwx.aka.frame.protocol.CallBackType;
import com.github.ulwx.aka.frame.protocol.InterType;
import com.github.ulwx.aka.frame.protocol.req.Protocol;
import com.github.ulwx.aka.webmvc.ActionMethodInfo;
import com.ulwx.tool.RequestUtils;
import com.ulwx.tool.SnowflakeIdWorker;

import javax.servlet.http.HttpServletRequest;


public class MyProtocolBuilder implements ProtocolBuilder {
    @Override
    public Protocol build(HttpServletRequest request,
                          ActionMethodInfo actionMethodInfo,
                          RequestUtils context) {
        Protocol protocol=new Protocol();
        protocol.setProtocolName(actionMethodInfo.getLogicActionMethodName());
        protocol.setCallBackType(CallBackType.NONE);
        protocol.setExtMap(null);
        protocol.setRequestBody(context.getBody());
        protocol.setRequestMap(context.getRequestParamMap());
        protocol.setInterType(InterType.JSON);
        protocol.setModuleName(actionMethodInfo.getMod());
        protocol.setPlatformNo("test-platform-no");
        protocol.setPlatformUserNo("");
        protocol.setRequestid(SnowflakeIdWorker.instance.nextId()+"");
        protocol.setRefRequestid("");
        protocol.setRemoteIp(context.getString(UiFrameConstants.PROTOCOL_REQ_REMOTE_IP));
        protocol.setTimestamp(System.currentTimeMillis());
        protocol.setUdid("");
        protocol.setUserid(context.getString("userid"));
        protocol.setNamespace(actionMethodInfo.getNamespace().getName());

        protocol.setServiceName(context.getString("serviceName"));
        protocol.setSourceId("");
        protocol.setVer("");

        return protocol;
    }
}
