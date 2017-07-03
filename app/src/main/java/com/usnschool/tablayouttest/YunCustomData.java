package com.usnschool.tablayouttest;

public class YunCustomData {
    private int idx;
    private String email;
    private String pw;
    public YunCustomData(int idx, String email, String pw){
        this.idx=idx;
        this.email=email;
        this.pw=pw;
    }

    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }
}
