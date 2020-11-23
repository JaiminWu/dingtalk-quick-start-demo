package com.service;

import com.pojo.At;
import com.pojo.BotMessage;
import com.pojo.Text;
import com.pojo.TextResponse;

import java.util.ArrayList;
import java.util.List;

public class ResponseText {

    public static TextResponse test (BotMessage botMessage) {

        Text text = new Text();
        text.setContent("你刚刚发给我的消息是：\"" + botMessage.getText().getContent() + "\" 机器人维护工程师是: @18819253238");

        At at = new At();
        at.setIsAtAll(false);
        List<String> atMobiles = new ArrayList<>();
        atMobiles.add("18819253238");
        at.setString(atMobiles);

        TextResponse textResponse = new TextResponse();
        textResponse.setText(text);
        textResponse.setAt(at);
        textResponse.setMsgtype("text");

        return textResponse;
    }
}
