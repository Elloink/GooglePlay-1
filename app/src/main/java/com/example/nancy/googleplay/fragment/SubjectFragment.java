package com.example.nancy.googleplay.fragment;

import android.os.SystemClock;
import android.view.View;
import android.widget.TextView;

import com.example.nancy.googleplay.base.BaseFragment;
import com.example.nancy.googleplay.base.LoadingPager;
import com.example.nancy.googleplay.util.UIUtils;

import java.util.Random;

/**
 * Created by Nancy on 2016/6/16.
 */
public class SubjectFragment extends BaseFragment {
    @Override
    public View initSuccessView() {
        // 返回成功的视图
        TextView tv = new TextView(UIUtils.getContext());
        tv.setText(this.getClass().getSimpleName());
        return tv;
    }

    @Override
    public LoadingPager.LoadedResult initData() {
        //加载数据(已经定义在子线程中)
        SystemClock.sleep(2000);
        //随机返回散户总状态中的一个
        LoadingPager.LoadedResult[] arr = {LoadingPager.LoadedResult.ERROR, LoadingPager.LoadedResult.EMPTY, LoadingPager.LoadedResult.SUCCESS};
        Random random = new Random();
        int index = random.nextInt(arr.length);// 0 1 2
        return arr[index];
    }
}
