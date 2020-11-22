package com.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author jaiminwu-stuff
 */

@Component
public class ApplicationConfiguration {
    @Value("${app.key}")
    public String APP_KEY;

    @Value("${app.secret}")
    public String APP_SECRET;

//    public String getAPP_KEY() {
//        return APP_KEY;
//    }
//
//    public void setAPP_KEY(String APP_KEY) {
//        this.APP_KEY = APP_KEY;
//    }
//
//    public String getAPP_SECRET() {
//        return APP_SECRET;
//    }
//
//    public void setAPP_SECRET(String APP_SECRET) {
//        this.APP_SECRET = APP_SECRET;
//    }
}
