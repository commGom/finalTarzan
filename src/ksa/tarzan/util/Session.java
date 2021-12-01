package ksa.tarzan.util;

import ksa.tarzan.dto.Member;

public class Session {
    private static Member user=null;

    public static Member getUser() {
        return user;
    }

    public static void setUser(Member user) {
        Session.user = user;
    }

}
