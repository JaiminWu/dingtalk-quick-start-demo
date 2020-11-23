package com.pojo;

import java.util.List;

public class At {
    private List<String> atMobiles ;

    private boolean isAtAll;

    public void setString(List<String> atMobiles){
        this.atMobiles = atMobiles;
    }
    public List<String> getString(){
        return this.atMobiles;
    }
    public void setIsAtAll(boolean isAtAll){
        this.isAtAll = isAtAll;
    }
    public boolean getIsAtAll(){
        return this.isAtAll;
    }
}
