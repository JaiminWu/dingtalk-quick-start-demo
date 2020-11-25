package com.util;

public class RandomStringUtil {
    /**
     * 生成随机字符串
     *
     * @param stringLength:生成的字符串长度
     * @return
     */
    public static String getRandomString(int stringLength) {
        String string = "abcdefghijklmnopqrstuvwxyz1234567890";
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < stringLength; i++) {
            //向下取整0-35
            int index = (int) Math.floor(Math.random() * string.length());
            sb.append(string.charAt(index));
        }
        return sb.toString();

    }

}
