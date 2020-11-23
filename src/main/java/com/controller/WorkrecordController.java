package com.controller;

import com.config.URLConstant;
import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiWorkrecordAddRequest;
import com.dingtalk.api.response.OapiWorkrecordAddResponse;
import com.pojo.User;
import com.taobao.api.ApiException;
import com.util.AccessTokenUtil;
import com.util.RandomStringUtil;
import com.util.ServiceResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class WorkrecordController {

    private static final Logger bizLogger = LoggerFactory.getLogger(IndexController.class);

    @RequestMapping(value = "/workrecord/add", method = RequestMethod.POST)
    public ServiceResult createWorkRecord(@RequestBody User user) {
        AccessTokenUtil accessTokenUtil = new AccessTokenUtil();
        String accessToken = accessTokenUtil.getToken();

        DingTalkClient client = new DefaultDingTalkClient(URLConstant.URL_CREATE_WORK_RECORD);
        OapiWorkrecordAddRequest req = new OapiWorkrecordAddRequest();
        req.setUserid(user.getUserId());
        long time = System.currentTimeMillis() + 86400000L;
        req.setCreateTime(time);
        req.setTitle("测试待办");
        req.setUrl("https://www.salesforce.com/ap/?ir=1");
        List<OapiWorkrecordAddRequest.FormItemVo> list2 = new ArrayList<OapiWorkrecordAddRequest.FormItemVo>();
        OapiWorkrecordAddRequest.FormItemVo obj3 = new OapiWorkrecordAddRequest.FormItemVo();
        list2.add(obj3);
        obj3.setTitle("测试标题: 由 " + user.getUserName() + " 提交");
        obj3.setContent("测试内容: " + RandomStringUtil.getRandomString(10));
        req.setFormItemList(list2);
        req.setOriginatorUserId(user.getUserId());
        String bizId = RandomStringUtil.getRandomString(16);
        req.setBizId(bizId);
        OapiWorkrecordAddResponse rsp = new OapiWorkrecordAddResponse();
        try {
            rsp = client.execute(req, accessToken);
            System.out.println(rsp.getBody());
        } catch (ApiException e) {
            e.printStackTrace();
        }
        String recordId = rsp.getRecordId();
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("recordId", recordId);
        resultMap.put("userId", user.getUserId());
        resultMap.put("bizId", bizId);
        return ServiceResult.success(resultMap);

    }
}
