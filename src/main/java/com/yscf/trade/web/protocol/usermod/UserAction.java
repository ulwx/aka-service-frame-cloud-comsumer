package com.yscf.trade.web.protocol.usermod;

import com.github.ulwx.aka.dbutils.springboot.resttemplate.AkaRestTemplateUtils;
import com.github.ulwx.aka.webmvc.annotation.AkaMvcActionMethod;
import com.github.ulwx.aka.webmvc.web.action.ActionSupport;
import com.github.ulwx.aka.webmvc.web.action.CbRequest;
import com.github.ulwx.aka.webmvc.web.action.CbResult;
import com.ulwx.tool.ObjectUtils;
import com.yscf.trade.web.protocol.usermod.domain.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.skywalking.apm.toolkit.trace.ActiveSpan;
import org.apache.skywalking.apm.toolkit.trace.TraceContext;
import org.springframework.http.ResponseEntity;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Tag(name = "用户接口",description = "通用用户接口" )
public class UserAction extends ActionSupport {

    @Operation(summary  = "测试登录", description  ="用于用户登录")
    @ApiResponse(description = "登录响应", useReturnTypeSchema=true)
    @RequestBody(description = " data in the json format", content = @Content(mediaType = "application/json"))
    @AkaMvcActionMethod(httpMethod = "post")
    public CbResult<LoginResponse> login( CbRequest<LoginRequest> request){
        AkaRestTemplateUtils templateUtils=this.beanGet.bean(AkaRestTemplateUtils.class);
        templateUtils.setServiceRequest(true);
        String url="http://aka-service-frame-cloud-provider/aka-service-frame-cloud-provider/prococol/usermod-User-loginJSON.action";
        ResponseEntity<String> ret=templateUtils.post(url,request,String.class);

        Type typeOfT = new com.google.gson.reflect.TypeToken<CbResult<LoginResponse>>(){}.getType();
        CbResult<LoginResponse> result=ObjectUtils.fromJsonToObject(ret.getBody(), typeOfT);

        LoginResponse response=result.getData();

        this.testTrace(response);
        return result;

    }
    @org.apache.skywalking.apm.toolkit.trace.Trace
    @org.apache.skywalking.apm.toolkit.trace.Tags({
            @org.apache.skywalking.apm.toolkit.trace.Tag(key = "name",value = "arg[0].userId"),
            @org.apache.skywalking.apm.toolkit.trace.Tag(key = "traceId",value = "returnedObj.traceId")})
    public Map<String,String> testTrace(LoginResponse myarg){
        Map<String,String> map=new HashMap<>();
        map.put("traceId", TraceContext.traceId());
        this.testInner();
        return map;
    }

    public void testInner(){
        ActiveSpan.tag("my_tag", "my_value");
        ActiveSpan.error("Test-Error-Reason");

    }
    @Operation(summary = "获取用户列表",description="用于获取用户列表，按条件查询")
    @RequestBody(description = " data in the json format", content = @Content(mediaType = "application/json"))
    @ApiResponse(description = "获取用户列表响应", useReturnTypeSchema=true)
    @AkaMvcActionMethod(httpMethod = "post", requestContentType ="application/json")
    public CbResult<List<MyUser>> getUserList(@RequestBody CbRequest<UserQuery> request){

        AkaRestTemplateUtils templateUtils=this.beanGet.bean(AkaRestTemplateUtils.class);
        templateUtils.setServiceRequest(true);
        String url="http://aka-service-frame-cloud-provider/aka-service-frame-cloud-provider/prococol/usermod-User-getUserListJSON.action";
        ResponseEntity<String> ret=templateUtils.post(url,request,String.class);
        Type typeOfT = new com.google.gson.reflect.TypeToken<CbResult<List<MyUser>>>(){}.getType();
        CbResult<List<MyUser>> result=ObjectUtils.fromJsonToObject(ret.getBody(), typeOfT);
        return result;

    }

    @Operation(summary  = "网关退出", description  ="用于用户网关退出")
    @ApiResponse(description = "响应", useReturnTypeSchema=true)
    @RequestBody(description = " data in the json format", content = @Content(mediaType = "application/json"))
    @AkaMvcActionMethod(httpMethod = "post")
    public CbResult<String> logout(@RequestBody CbRequest<LogoutRequset> request){
        AkaRestTemplateUtils templateUtils=this.beanGet.bean(AkaRestTemplateUtils.class);
        templateUtils.setServiceRequest(true);
        String url="http://aka-service-frame-cloud-provider/aka-service-frame-cloud-provider/prococol/usermod-User-logoutJSON.action";
        ResponseEntity<String> ret=templateUtils.post(url,request,String.class);
        Type typeOfT = new com.google.gson.reflect.TypeToken<CbResult<String>>(){}.getType();
        CbResult<String> result=ObjectUtils.fromJsonToObject(ret.getBody(), typeOfT);
        return result;
    }
}
