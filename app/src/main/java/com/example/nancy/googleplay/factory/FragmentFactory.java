package com.example.nancy.googleplay.factory;

import android.support.v4.util.SparseArrayCompat;

import com.example.nancy.googleplay.base.BaseFragment;
import com.example.nancy.googleplay.fragment.AppFragment;
import com.example.nancy.googleplay.fragment.CategoryFragment;
import com.example.nancy.googleplay.fragment.GameFragment;
import com.example.nancy.googleplay.fragment.HomeFragment;
import com.example.nancy.googleplay.fragment.HotFragment;
import com.example.nancy.googleplay.fragment.RecommendFragment;
import com.example.nancy.googleplay.fragment.SubjectFragment;

/**
 * Created by Nancy on 2016/6/16.
 */
public class FragmentFactory {

    /**
     * <string-array name="main_titles">
     * <item>首页</item>
     * <item>应用</item>
     * <item>游戏</item>
     * <item>专题</item>
     * <item>推荐</item>
     * <item>分类</item>
     * <item>排行</item>
     * </string-array>
     */
    public static final int FRAGMENT_HOME = 0;
    public static final int FRAGMENT_APP = 1;
    public static final int FRAGMENT_GAME = 2;
    public static final int FRAGMENT_SUBJECT = 3;
    public static final int FRAGMENT_RECOMMEND = 4;
    public static final int FRAGMENT_CATEGORY = 5;
    public static final int FRAGMENT_HOT = 6;

    private static SparseArrayCompat<BaseFragment> cachesFragment = new SparseArrayCompat<>();

    public static BaseFragment getFragment(int position) {
        BaseFragment fragment = null;

        if (cachesFragment.get(position) != null) {
            //如果缓存里面有对应的fragment，就直接取出
            return cachesFragment.get(position);
        }


        switch (position) {
            case FRAGMENT_HOME:// 主页
                fragment = new HomeFragment();
                break;
            case FRAGMENT_APP:// 应用
                fragment = new AppFragment();
                break;
            case FRAGMENT_GAME:// 游戏
                fragment = new GameFragment();
                break;
            case FRAGMENT_SUBJECT:// 专题
                fragment = new SubjectFragment();
                break;
            case FRAGMENT_RECOMMEND:// 推荐
                fragment = new RecommendFragment();
                break;
            case FRAGMENT_CATEGORY:// 分类
                fragment = new CategoryFragment();
                break;
            case FRAGMENT_HOT:// 排行
                fragment = new HotFragment();
                break;
        }

        //保存对应的fragment
        cachesFragment.put(position, fragment);
        return fragment;
    }


}
