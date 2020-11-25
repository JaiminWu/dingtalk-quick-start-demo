package com.util;

import com.config.URLConstant;
import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiUserGetRequest;
import com.dingtalk.api.response.OapiUserGetResponse;
import com.taobao.api.ApiException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserInfoUtil {

    private static final Logger bizLogger = LoggerFactory.getLogger(AccessTokenUtil.class);


    /**
     * 获取用户姓名
     *
     * @param accessToken
     * @param userId
     * @return
     */
    public static String getUserName(String accessToken, String userId) {
        try {
            DingTalkClient client = new DefaultDingTalkClient(URLConstant.URL_USER_GET);
            OapiUserGetRequest request = new OapiUserGetRequest();
            request.setUserid(userId);
            request.setHttpMethod("GET");
            OapiUserGetResponse response = client.execute(request, accessToken);
            return response.getName();
        } catch (ApiException e) {
            e.printStackTrace();
            return null;
        }
    }
}
