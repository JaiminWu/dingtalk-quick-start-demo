package com.controller;

import com.pojo.BotMessage;
import com.pojo.Text;
import com.pojo.TextResponse;
import com.service.ResponseText;
import com.service.VerifySign;
import com.util.ServiceResult;
import org.apache.http.client.HttpResponseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

@RestController
public class BotController {

    private static final Logger bizLogger = LoggerFactory.getLogger(BotController.class);

    @RequestMapping(value = "/bot/receive", method = RequestMethod.POST)
    public TextResponse receive(@RequestBody BotMessage botMessage, @RequestHeader("timestamp") String timestamp, @RequestHeader("sign") String sign) throws InvalidKeyException, NoSuchAlgorithmException, HttpResponseException, UnsupportedEncodingException {
            VerifySign.verify(timestamp, sign);
            return ResponseText.test(botMessage);
    }
}
