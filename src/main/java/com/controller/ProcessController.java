package com.controller;

import com.config.Constant;
import com.config.URLConstant;
import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiProcessinstanceCreateRequest;
import com.dingtalk.api.response.OapiProcessinstanceCreateResponse;
import com.pojo.ProcessRequest;
import com.pojo.User;
import com.service.ProcessTest;
import com.taobao.api.ApiException;
import com.util.AccessTokenUtil;
import com.util.ServiceResult;
import com.util.UserInfoUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jaiminwu-stuff
 */
@RestController
public class ProcessController {

    private static final Logger bizLogger = LoggerFactory.getLogger(IndexController.class);

    @RequestMapping(value = "/process/add", method = RequestMethod.POST)
    public ServiceResult processAdd (@RequestBody ProcessRequest processRequest) {
        AccessTokenUtil accessTokenUtil = new AccessTokenUtil();
        String accessToken = accessTokenUtil.getToken();
        String userName = UserInfoUtil.getUserName(accessToken, processRequest.getOriginatorUserId());
        DingTalkClient client = new DefaultDingTalkClient(URLConstant.URL_CREATE_PROCESS_INSTANCE);
        OapiProcessinstanceCreateRequest req = new OapiProcessinstanceCreateRequest();
        req.setAgentId(Constant.AGENT_ID);
        req.setProcessCode(processRequest.getProcessCode());
        req.setOriginatorUserId(processRequest.getOriginatorUserId());
        req.setDeptId(processRequest.getDeptId());
        req.setApprovers(processRequest.getApprovers());
//        List<OapiProcessinstanceCreateRequest.FormComponentValueVo> list2 = new ArrayList<OapiProcessinstanceCreateRequest.FormComponentValueVo>();
//        OapiProcessinstanceCreateRequest.FormComponentValueVo obj3 = new OapiProcessinstanceCreateRequest.FormComponentValueVo();
//        list2.add(obj3);
//        obj3.setName("Test");
//        obj3.setValue("Test by user: " + userName);
//        List<OapiProcessinstanceCreateRequest.FormComponentValueVo> list2 = ProcessTest.test1();
//        List<OapiProcessinstanceCreateRequest.FormComponentValueVo> list2 = ProcessTest.test2();
//        req.setFormComponentValues(list2);
        req.setFormComponentValues(processRequest.getFormComponentValues());
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
