package com.util;

import com.config.Constant;
import org.apache.commons.codec.binary.Base64;
import org.apache.http.client.HttpResponseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.HttpClientErrorException;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class SignVerifyUtil {

    private static final Logger bizLogger = LoggerFactory.getLogger(AccessTokenUtil.class);


    public static boolean verifySign(String timestamp, String sign) throws NoSuchAlgorithmException, UnsupportedEncodingException, InvalidKeyException {
//        Long timestamp = 1577262236757L;
        String stringToSign = timestamp + "\n" + Constant.BOT_APP_SECRET;
        Mac mac = Mac.getInstance("HmacSHA256");
        mac.init(new SecretKeySpec(Constant.BOT_APP_SECRET.getBytes("UTF-8"), "HmacSHA256"));
        byte[] signData = mac.doFinal(stringToSign.getBytes("UTF-8"));
        String signFromTimestamp = new String(Base64.encodeBase64(signData));
        return signFromTimestamp.equals(sign);
    }
}
