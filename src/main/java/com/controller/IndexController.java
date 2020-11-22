package com.controller;

import com.config.Constant;
import com.config.URLConstant;
import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiProcessinstanceCreateRequest;
import com.dingtalk.api.request.OapiUserGetRequest;
import com.dingtalk.api.request.OapiUserGetuserinfoRequest;
import com.dingtalk.api.response.OapiProcessinstanceCreateResponse;
import com.dingtalk.api.response.OapiUserGetResponse;
import com.dingtalk.api.response.OapiUserGetuserinfoResponse;
import com.taobao.api.ApiException;
import com.util.AccessTokenUtil;
import com.util.ServiceResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * 企业内部内部-小程序Quick-Start示例代码 实现了最简单的免密登录（免登）功能
 */
@RestController
public class IndexController {
    private static final Logger bizLogger = LoggerFactory.getLogger(IndexController.class);

    /**
     * 欢迎页面,通过url访问，判断后端服务是否启动
     */
    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public String welcome() {
        return "welcome";
    }

    /**
     * 钉钉用户登录，显示当前登录用户的userId和名称
     *
     * @param requestAuthCode 免登临时code
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public ServiceResult login(@RequestParam(value = "authCode") String requestAuthCode) {
        //获取accessToken,注意正是代码要有异常流处理
        AccessTokenUtil accessTokenUtil = new AccessTokenUtil();
        String accessToken = accessTokenUtil.getToken();

        //获取用户信息
        DingTalkClient client = new DefaultDingTalkClient(URLConstant.URL_GET_USER_INFO);
        OapiUserGetuserinfoRequest request = new OapiUserGetuserinfoRequest();
        request.setCode(requestAuthCode);
        request.setHttpMethod("GET");

        OapiUserGetuserinfoResponse response;
        try {
            response = client.execute(request, accessToken);
        } catch (ApiException e) {
            e.printStackTrace();
            return null;
        }
        //3.查询得到当前用户的userId
        // 获得到userId之后应用应该处理应用自身的登录会话管理（session）,避免后续的业务交互（前端到应用服务端）每次都要重新获取用户身份，提升用户体验
        String userId = response.getUserid();

        String userName = getUserName(accessToken, userId);

        System.out.println(userName);
        //返回结果
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("userId", userId);
        resultMap.put("userName", userName);
        ServiceResult serviceResult = ServiceResult.success(resultMap);
        return serviceResult;
    }

    @RequestMapping(value = "/submitApproval", method = RequestMethod.POST)
    @ResponseBody
    public ServiceResult submitApproval (@RequestParam(value = "userId") String userId) {
        AccessTokenUtil accessTokenUtil = new AccessTokenUtil();
        String accessToken = accessTokenUtil.getToken();
        DingTalkClient client = new DefaultDingTalkClient(URLConstant.URL_CREATE_PROCESS_INSTANCE);
        OapiProcessinstanceCreateRequest req = new OapiProcessinstanceCreateRequest();
        req.setAgentId(Constant.AGENT_ID);
        req.setProcessCode("PROC-938EC5CD-9332-4BF3-935A-161A868F894B");
        req.setOriginatorUserId(userId);
        req.setDeptId(-1L);
        req.setApprovers(userId);
        List<OapiProcessinstanceCreateRequest.FormComponentValueVo> list2 = new ArrayList<OapiProcessinstanceCreateRequest.FormComponentValueVo>();
        OapiProcessinstanceCreateRequest.FormComponentValueVo obj3 = new OapiProcessinstanceCreateRequest.FormComponentValueVo();
        list2.add(obj3);
        obj3.setName("Test");
        String userName = getUserName(accessToken, userId);
        obj3.setValue("Test by user: " + userName);
        req.setFormComponentValues(list2);
        OapiProcessinstanceCreateResponse rsp = new OapiProcessinstanceCreateResponse();
        try {
            rsp = client.execute(req, accessToken);
            System.out.println(rsp.getBody());
        } catch (ApiException e) {
            e.printStackTrace();
        }
        String processInstanceId = rsp.getProcessInstanceId();
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("processInstanceId", processInstanceId);
        resultMap.put("userName", userName);
        return ServiceResult.success(resultMap);

    }

    /**
     * 获取用户姓名
     *
     * @param accessToken
     * @param userId
     * @return
     */
    private String getUserName(String accessToken, String userId) {
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


