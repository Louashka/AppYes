package com.tataev.yes;

import android.graphics.Bitmap;

/**
 * Created by lou on 17.09.2015.
 */
public class UsersList {

    Bitmap userBitmap;
    String userName;
    Boolean userStatus;

    public UsersList (Bitmap userBitmap, String userName, Boolean userStatus) {
        this.userBitmap = userBitmap;
        this.userName= userName;
        this.userStatus = userStatus;
    }

    public Bitmap getUserBitmap (){

        return this.userBitmap;
    }

    public void setUserBitmap (Bitmap userBitmap){

        this.userBitmap = userBitmap;
    }

    public String getUserName (){

        return this.userName;
    }

    public void setUserName (String userName){

        this.userName = userName;
    }

    public Boolean getUserStatus (){

        return this.userStatus;
    }

    public void setUserStatus (Boolean userStatus){

        this.userStatus = userStatus;
    }
}
