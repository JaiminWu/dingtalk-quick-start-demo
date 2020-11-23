package com.util;

import com.config.ApplicationConfiguration;
import com.config.Constant;
import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.request.OapiGettokenRequest;
import com.dingtalk.api.response.OapiGettokenResponse;
import com.taobao.api.ApiException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import static com.config.URLConstant.URL_GET_TOKKEN;

/**
 * 获取access_token工具类
 */
public class AccessTokenUtil {

    private static final Logger bizLogger = LoggerFactory.getLogger(AccessTokenUtil.class);

//    @Autowired
//    private ApplicationConfiguration applicationConfiguration;

    public String getToken() throws RuntimeException {
        try {
            DefaultDingTalkClient client = new DefaultDingTalkClient(URL_GET_TOKKEN);
            OapiGettokenRequest request = new OapiGettokenRequest();

            request.setAppkey(Constant.APP_KEY);
            request.setAppsecret(Constant.APP_SECRET);
//            ApplicationConfiguration config = new ApplicationConfiguration();
//            System.out.println("APP_KEY From Local Properties:" + applicationConfiguration.APP_KEY);
//            System.out.println("APP_SECRET From Local Properties:" + applicationConfiguration.APP_SECRET);
//            request.setAppkey(applicationConfiguration.APP_KEY);
//            request.setAppsecret(applicationConfiguration.APP_SECRET);
            request.setHttpMethod("GET");
            OapiGettokenResponse response = client.execute(request);
            System.out.println("Access_Token: " + response.getAccessToken());
            return response.getAccessToken();
        } catch (ApiException e) {
            bizLogger.error("getAccessToken failed", e);
            throw new RuntimeException();
        }

    }

    public static void main(String[] args)throws ApiException{
        AccessTokenUtil accessTokenUtil = new AccessTokenUtil();
        String accessToken = accessTokenUtil.getToken();
        System.out.println(accessToken);
    }
}
