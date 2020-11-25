package com.controller;

import com.config.Constant;
import com.config.URLConstant;
import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiProcessinstanceCreateRequest;
import com.dingtalk.api.response.OapiProcessinstanceCreateResponse;
import com.taobao.api.ApiException;
import com.util.AccessTokenUtil;
import com.util.ServiceResult;
import com.util.UserInfoUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProcessController {

    private static final Logger bizLogger = LoggerFactory.getLogger(IndexController.class);

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
        String userName = UserInfoUtil.getUserName(accessToken, userId);
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
}