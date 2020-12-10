package com.service;

import com.alibaba.fastjson.JSONObject;
import com.dingtalk.api.request.OapiProcessinstanceCreateRequest;
import com.util.RandomStringUtil;

import java.util.ArrayList;
import java.util.List;

public class ProcessTest {

    //Test Smart Flow
    public static List<OapiProcessinstanceCreateRequest.FormComponentValueVo> test1() {

        OapiProcessinstanceCreateRequest.FormComponentValueVo vo = new OapiProcessinstanceCreateRequest.FormComponentValueVo();
        vo.setName("客户访问标题");
        vo.setValue("Test");

        OapiProcessinstanceCreateRequest.FormComponentValueVo vo1 = new OapiProcessinstanceCreateRequest.FormComponentValueVo();
        vo1.setName("客户访问ID");
        vo1.setValue("id" + RandomStringUtil.getRandomString(15));

        OapiProcessinstanceCreateRequest.FormComponentValueVo vo2 = new OapiProcessinstanceCreateRequest.FormComponentValueVo();
        vo2.setName("客户名称");
        vo2.setValue("Test");

        OapiProcessinstanceCreateRequest.FormComponentValueVo vo3 = new OapiProcessinstanceCreateRequest.FormComponentValueVo();
        vo3.setName("联系人姓名");
        vo3.setValue("Test");

        OapiProcessinstanceCreateRequest.FormComponentValueVo vo4 = new OapiProcessinstanceCreateRequest.FormComponentValueVo();
        vo4.setName("逾期时间");
        vo4.setValue("2020-11-30 23:00");

//        OapiProcessinstanceCreateRequest.FormComponentValueVo vo5 = new OapiProcessinstanceCreateRequest.FormComponentValueVo();
//        vo5.setName("当前地点");
//        vo5.setValue("广东省广州市天河区珠江新城");

        OapiProcessinstanceCreateRequest.FormComponentValueVo vo6 = new OapiProcessinstanceCreateRequest.FormComponentValueVo();
        vo6.setName("访问小结");
        vo6.setValue("Test");

//        OapiProcessinstanceCreateRequest.FormComponentValueVo vo7 = new OapiProcessinstanceCreateRequest.FormComponentValueVo();
//        vo7.setName("访问人");
//        JSONObject contactObj = new JSONObject();
//        contactObj.put("name", "联系人");
//        List<String> userIdList = new ArrayList<String>();
//        userIdList.add("020140602226851070");
//        contactObj.put("value", userIdList);
//        vo7.setValue(contactObj.toJSONString());

        List<OapiProcessinstanceCreateRequest.FormComponentValueVo> list = new ArrayList<OapiProcessinstanceCreateRequest.FormComponentValueVo>();
        list.add(vo);
        list.add(vo1);
        list.add(vo2);
        list.add(vo3);
        list.add(vo4);
//        list.add(vo5);
        list.add(vo6);
//        list.add(vo7);
        return list;
    }

    //DingTalk&Salesforce Integration POC
    public static List<OapiProcessinstanceCreateRequest.FormComponentValueVo> test2() {
        OapiProcessinstanceCreateRequest.FormComponentValueVo vo = new OapiProcessinstanceCreateRequest.FormComponentValueVo();
        vo.setName("审批名称");
        vo.setValue("Test");

        OapiProcessinstanceCreateRequest.FormComponentValueVo vo1 = new OapiProcessinstanceCreateRequest.FormComponentValueVo();
        vo1.setName("描述");
        vo1.setValue("Test");

        List<OapiProcessinstanceCreateRequest.FormComponentValueVo> list = new ArrayList<OapiProcessinstanceCreateRequest.FormComponentValueVo>();
        list.add(vo);
        list.add(vo1);
        return list;
    }
}
