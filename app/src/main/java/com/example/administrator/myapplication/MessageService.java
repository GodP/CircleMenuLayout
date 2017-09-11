package com.example.administrator.myapplication;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;

/**
 * Created by Administrator on 2017/8/29 0029.
 */

public class MessageService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return new UserBinder();
    }



    private class  UserBinder extends UserAidl.Stub{

        @Override
        public String getUserName() throws RemoteException {
            return "460030789@qq.com";
        }

        @Override
        public String getUserPwd() throws RemoteException {
            return "920411";
        }
    }
}
