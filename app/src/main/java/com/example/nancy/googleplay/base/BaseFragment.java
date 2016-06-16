package com.example.nancy.googleplay.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nancy.googleplay.util.LogUtils;
import com.example.nancy.googleplay.util.UIUtils;

/**
 * Created by Nancy on 2016/6/16.
 */
public abstract class BaseFragment extends Fragment {
    private LoadingPager mLoadingPager;

    public LoadingPager getLoadingPager() {
        return mLoadingPager;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mLoadingPager == null) {
            //第一次执行
            mLoadingPager = new LoadingPager(UIUtils.getContext()) {
                @Override
                public View initSuccessView() {
                    return BaseFragment.this.initSuccessView();
                }

                @Override
                public LoadedResult initData() {
                    return BaseFragment.this.initData();
                }
            };
        } else {
            //不是第一次执行
            ((ViewGroup) mLoadingPager.getParent()).removeView(mLoadingPager);
            LogUtils.sf(mLoadingPager.getParent().getClass().getSimpleName());
        }
        return mLoadingPager;
    }

    public abstract View initSuccessView();

    public abstract LoadingPager.LoadedResult initData();
}
