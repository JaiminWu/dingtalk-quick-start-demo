package com.pojo;

import java.util.List;

public class BotMessage {
    private String msgtype;

    private Text text;

    private String msgId;

    private Long createAt;

    private String conversationType;

    private String conversationId;

    private String conversationTitle;

    private String senderId;

    private String senderNick;

    private String senderCorpId;

    private String senderStaffId;

    private String chatbotUserId;

    private List<AtUsers> atUsers ;

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
    public void setMsgId(String msgId){
        this.msgId = msgId;
    }
    public String getMsgId(){
        return this.msgId;
    }
    public void setCreateAt(Long createAt){
        this.createAt = createAt;
    }
    public Long getCreateAt(){
        return this.createAt;
    }
    public void setConversationType(String conversationType){
        this.conversationType = conversationType;
    }
    public String getConversationType(){
        return this.conversationType;
    }
    public void setConversationId(String conversationId){
        this.conversationId = conversationId;
    }
    public String getConversationId(){
        return this.conversationId;
    }
    public void setConversationTitle(String conversationTitle){
        this.conversationTitle = conversationTitle;
    }
    public String getConversationTitle(){
        return this.conversationTitle;
    }
    public void setSenderId(String senderId){
        this.senderId = senderId;
    }
    public String getSenderId(){
        return this.senderId;
    }
    public void setSenderNick(String senderNick){
        this.senderNick = senderNick;
    }
    public String getSenderNick(){
        return this.senderNick;
    }
    public void setSenderCorpId(String senderCorpId){
        this.senderCorpId = senderCorpId;
    }
    public String getSenderCorpId(){
        return this.senderCorpId;
    }
    public void setSenderStaffId(String senderStaffId){
        this.senderStaffId = senderStaffId;
    }
    public String getSenderStaffId(){
        return this.senderStaffId;
    }
    public void setChatbotUserId(String chatbotUserId){
        this.chatbotUserId = chatbotUserId;
    }
    public String getChatbotUserId(){
        return this.chatbotUserId;
    }
    public void setAtUsers(List<AtUsers> atUsers){
        this.atUsers = atUsers;
    }
    public List<AtUsers> getAtUsers(){
        return this.atUsers;
    }
}
