package com.example.nancy.googleplay;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

import com.astuetz.PagerSlidingTabStripExtends;
import com.example.nancy.googleplay.base.BaseFragment;
import com.example.nancy.googleplay.factory.FragmentFactory;
import com.example.nancy.googleplay.util.LogUtils;
import com.example.nancy.googleplay.util.UIUtils;

public class MainActivity extends AppCompatActivity {

    private PagerSlidingTabStripExtends mTabs;
    private ViewPager mViewPager;
    private String[] mMainTitles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initView();
        initActionBar();
        initData();
        initEvent();


    }

    private void initData() {
        //获得页签的标题
        mMainTitles = UIUtils.getStringArr(R.array.main_titles);

        MainFragmentStatePagerAdapter adapter = new MainFragmentStatePagerAdapter(getSupportFragmentManager());

        mViewPager.setAdapter(adapter);
        //给页签绑定一个viewPager
        mTabs.setViewPager(mViewPager);


    }

    private void initEvent() {
        //这里应该给Tab设定这个事件，而不是给viewPager设定
        mTabs.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                //todo 之所以放在这里是希望在选中的时候在加载数据（因为默认情况下ViewPager有预加载功能，如果在Fragment中写的话会直接加载数据，浪费用户流量）
                //完成触发加载
                BaseFragment fragment = FragmentFactory.getFragment(position);
                if (fragment != null) {
                    fragment.getLoadingPager().loadData();
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    private void initActionBar() {
        ActionBar actionBar = getSupportActionBar();

        if (actionBar != null) {
            actionBar.setLogo(R.drawable.ic_launcher);
            actionBar.setTitle("GooglePlay");
        }

    }

    private void initView() {
        setContentView(R.layout.activity_main);

        mTabs = (PagerSlidingTabStripExtends) findViewById(R.id.psts_main_tags);
        mViewPager = (ViewPager) findViewById(R.id.vp_main_content);

    }

    class MainFragmentStatePagerAdapter extends FragmentStatePagerAdapter {


        public MainFragmentStatePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            LogUtils.sf("初始化" + mMainTitles[position]);
            return FragmentFactory.getFragment(position);
        }

        @Override
        public int getCount() {
            if (mMainTitles != null) {
                return mMainTitles.length;
            } else {
                return 0;
            }
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mMainTitles[position];
        }
    }

}
