package com.example.springlearn.video4_bean_reference.bean;

public class WorldBean {

    private String content;

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return content;
    }
}
