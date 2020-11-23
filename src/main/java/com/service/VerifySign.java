package com.service;

import com.util.SignVerifyUtil;
import org.apache.http.client.HttpResponseException;
import org.springframework.web.client.HttpClientErrorException;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class VerifySign {

    public static void verify(String timestamp, String sign) throws HttpResponseException, NoSuchAlgorithmException, InvalidKeyException, UnsupportedEncodingException {
        if (!SignVerifyUtil.verifySign(timestamp, sign)){
            throw new HttpResponseException(401, "验签未通过");
        }
    }

}
