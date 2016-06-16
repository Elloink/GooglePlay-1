package com.example.nancy.googleplay.base;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;

/**
 * 定义一个全局的盒子。里面防止的对象、属性、方法都是全局可以调用的
 * Created by Nancy on 2016/6/15.
 */
public class BaseApplication extends Application {

    public static Context getContext() {
        return mContext;
    }

    public static Thread getMainThread() {
        return mMainThread;
    }

    public static int getMainThreadId() {
        return mMainThreadId;
    }

    public static Looper getMainThreadLooper() {
        return mMainLooper;
    }

    public static Handler getHandler() {
        return mHandler;
    }

    private static Context mContext;
    private static Thread mMainThread;
    private static int mMainThreadId;
    private static Looper mMainLooper;
    private static Handler mHandler;

    @Override
    public void onCreate() {
        super.onCreate();
        //初始化一些常用属性

        mContext = getApplicationContext();//上下文
        mMainThread = Thread.currentThread();//主线程
        mMainThreadId = android.os.Process.myTid();//主线程ID
        // tid thread/uid  user/pid process

        mMainLooper = getMainLooper();//主线程looper
        mHandler = new Handler();//定义一个主线程handler
    }
}
