package com.Obj;

public class infoObj {
    private String timestamp;
    private String text;
    private String username;
    private boolean isdelete;

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isIsdelete() {
        return isdelete;
    }

    @Override
    public String toString() {
        return "info{" +
                "timestamp='" + timestamp + '\'' +
                ", text='" + text + '\'' +
                ", username='" + username + '\'' +
                ", isdelete=" + isdelete +
                '}';
    }

    public void setIsdelete(boolean isdelete) {
        this.isdelete = isdelete;
    }

    public infoObj(String timestamp, String text, String username, boolean isdelete) {
        this.timestamp = timestamp;
        this.text = text;
        this.username = username;
        this.isdelete = isdelete;
    }

    public infoObj() {
    }
}
