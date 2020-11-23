package com.pojo;

public class TextResponse {
    private String msgtype;

    private Text text;

    private At at;

    public void setMsgtype(String msgtype){
        this.msgtype = msgtype;
    }
    public String getMsgtype(){
        return this.msgtype;
    }
    public void setText(Text text){
        this.text = text;
    }
    public Text getText(){
        return this.text;
    }
    public void setAt(At at){
        this.at = at;
    }
    public At getAt(){
        return this.at;
    }
}
