package com.service;

import com.pojo.At;
import com.pojo.Text;
import com.pojo.TextResponse;

import java.util.ArrayList;
import java.util.List;

public class ResponseText {

    public static TextResponse test () {

        Text text = new Text();
        text.setContent("This is a text");

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
