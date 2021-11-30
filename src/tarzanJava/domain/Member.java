package tarzanJava.domain;

import java.io.Serializable;
import java.util.ArrayList;

public class Member  {
    private String memId;
    private String memPw;
    private String nickName;
    private int score;

    public Member() {
    }

    public Member(String memId, String memPw, String nickName) {
        this.memId = memId;
        this.memPw = memPw;
        this.nickName = nickName;
    }

    public String getMemId() {
        return memId;
    }

    public void setMemId(String memId) {
        this.memId = memId;
    }

    public String getMemPw() {
        return memPw;
    }

    public void setMemPw(String memPw) {
        this.memPw = memPw;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }


    @Override
    public String toString() {
        return "Member{" +
                "memId='" + memId + '\'' +
                ", memPw='" + memPw + '\'' +
                ", nickName='" + nickName + '\'' +
                ", score=" + score +
                '}';
    }
}
