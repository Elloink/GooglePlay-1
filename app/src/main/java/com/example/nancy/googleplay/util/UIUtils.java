package com.example.nancy.googleplay.util;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;

import com.example.nancy.googleplay.base.BaseApplication;

/**
 * Created by Nancy on 2016/6/15.
 */
public class UIUtils {
    //得到上下文
    public static Context getContext() {
        return BaseApplication.getContext();
    }

    //得到Resource
    public static Resources getResource() {
        return getContext().getResources();
    }

    //得到String.xml中的字符串
    public static String getString(int resId) {
        return getResource().getString(resId);
    }

    //得到String.xml中的字符串数组
    public static String[] getStringArr(int resId) {
        return getResource().getStringArray(resId);
    }

    //得到colors.xml中的颜色
    public static int getColor(int colorId) {
        return getResource().getColor(colorId);
    }

    //得到包名
    public static String getPackageName() {
        return getContext().getPackageName();
    }

    //得到主线程id
    public static long getMainThreadId() {
        return BaseApplication.getMainThreadId();
    }

    //得到主线程Handler
    public static Handler getMainThreadHandler() {
        return BaseApplication.getHandler();
    }

    //安全的执行一个任务（主线程的话直接执行，如果是子线程的话，将其放到主线程执行）

    public static void postTaskSafely(Runnable runnable) {
        int curThreadId = android.os.Process.myTid();

        if (curThreadId == getMainThreadId()) {//如果当前线程是主线程
            runnable.run();
        } else {
            //如果不是主线程
            getMainThreadHandler().post(runnable);
        }

    }


}
