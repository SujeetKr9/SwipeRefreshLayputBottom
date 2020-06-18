package com.sujeet.swiperefreshlayoutbottom;

public class UserModel {
    String userNmae;
    String userMobile;

    public UserModel(String userNmae, String userMobile) {
        this.userNmae = userNmae;
        this.userMobile = userMobile;
    }

    public String getUserNmae() {
        return userNmae;
    }

    public String getUserMobile() {
        return userMobile;
    }
}
