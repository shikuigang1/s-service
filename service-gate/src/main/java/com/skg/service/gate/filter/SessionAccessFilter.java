package com.skg.service.gate.filter;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.skg.service.gate.redis.config.JedisClusterUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.net.URLEncoder;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

@Component
@Slf4j
public class SessionAccessFilter extends ZuulFilter {

  /*  @Autowired
    private IUserService userService;
    @Autowired
    private ILogService logService;*/

    @Value("${gate.ignore.startWith}")
    private String startWith;

    /*@Value("${zuul.prefix}")
    private String zuulPrefix;*/

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
       // final String requestUri = request.getRequestURI().substring(zuulPrefix.length());
        final String method = request.getMethod();

        //url 验证是否 需要拦截
        //System.out.println(requestUri);

        String  access_token = request.getParameter("access_token");
        System.out.println(request.getRequestURI());
        System.out.println(access_token);
        System.out.println(request.getSession().getId());




        //JedisClusterUtils.getBean();

        /*BaseContextHandler.setToken(null);
        // 不进行拦截的地址
        if (isStartWith(requestUri))
            return null;
        IJWTInfo user = null;
        try {
            user = getJWTUser(request);
            ctx.addZuulRequestHeader(userAuthConfig.getTokenHeader(),BaseContextHandler.getToken());
        } catch (Exception e) {
            setFailedRequest(JSON.toJSONString(new TokenErrorResponse(e.getMessage())),200);
            return null;
        }

        List<PermissionInfo> permissionInfos = userService.getAllPermissionInfo();
        // 判断资源是否启用权限约束
        Collection<PermissionInfo> result = getPermissionInfos(requestUri, method, permissionInfos);
        if(result.size()>0){
            checkAllow(requestUri, method, ctx, user.getUniqueName());
        }

        // 申请客户端密钥头
        BaseResponse resp = serviceAuthFeign.getAccessToken(serviceAuthConfig.getClientId(), serviceAuthConfig.getClientSecret());
        if(resp.getStatus() == 200){
            ObjectRestResponse<String> clientToken = (ObjectRestResponse<String>) resp;
            ctx.addZuulRequestHeader(serviceAuthConfig.getTokenHeader(),clientToken.getData());
        }else {
            setFailedRequest(JSON.toJSONString(new BaseResponse(CommonConstants.EX_CLIENT_INVALID_CODE,"Token Error or Token Expired!")),200);
        }*/

        return null;
    }


}
