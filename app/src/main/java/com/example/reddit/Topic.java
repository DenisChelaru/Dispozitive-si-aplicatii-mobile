package com.example.reddit;

public class Topic {
    private String numeTopic;

    public Topic(String numeTopic) {
        this.numeTopic = numeTopic;
    }

    public String getNumeTopic() {
        return numeTopic;
    }

    public void setNumeTopic(String numeTopic) {
        this.numeTopic = numeTopic;
    }

    @Override
    public String toString() {
        return "Topic{" +
                "numeTopic='" + numeTopic + '\'' +
                '}';
    }
}
