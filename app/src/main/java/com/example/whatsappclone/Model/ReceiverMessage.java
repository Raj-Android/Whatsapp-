package com.example.whatsappclone.Model;

public class ReceiverMessage {
    String uid, message;
    Long timestamp;

    //Create Constructor
    public ReceiverMessage(String uid, String message, Long timestamp) {
        this.uid = uid;
        this.message = message;
        this.timestamp = timestamp;
    }

    public ReceiverMessage(String uid, String message) {
        this.uid = uid;
        this.message = message;
    }

    //we use firebase then it is compulsory to create empty constructor
    public ReceiverMessage() {
    }

    //Create getter and setter
    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }
}
