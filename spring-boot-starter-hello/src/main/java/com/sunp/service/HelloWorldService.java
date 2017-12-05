package com.sunp.service;

public class HelloWorldService {
    private String word;

    public String getWelcome(){
        return "welcome "+word;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }
}
