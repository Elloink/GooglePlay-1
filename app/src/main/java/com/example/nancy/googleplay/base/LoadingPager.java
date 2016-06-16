package com.example.nancy.googleplay.base;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;

import com.example.nancy.googleplay.R;
import com.example.nancy.googleplay.util.UIUtils;

/**
 * Created by Nancy on 2016/6/15.
 */
public class LoadingPager extends FrameLayout {

    public static final int STATE_NONE = -1;            // 默认情况
    public static final int STATE_LOADING = 0;            // 正在请求网络
    public static final int STATE_EMPTY = 1;            // 空状态
    public static final int STATE_ERROR = 2;            // 错误状态
    public static final int STATE_SUCCESS = 3;            // 成功状态

    public int mCurState = STATE_NONE;

    /**
     * //页面显示分析
     * //Fragment共性-->页面共性-->视图的展示
     * /**
     * 任何应用其实就只有4种页面类型
     * ① 加载页面
     * ② 错误页面
     * ③ 空页面
     * ④ 成功页面
     * <p/>
     * ①②③三种页面一个应用基本是固定的
     * 每一个fragment/activity对应的页面④就不一样
     * 进入应用的时候显示①,②③④需要加载数据之后才知道显示哪个
     */

    private View mLoadingView;
    private View mErrorView;
    private View mEmptyView;

    public LoadingPager(Context context) {
        super(context);
        initCommonView();
    }

    /**
     * 初始化常规视图
     */
    private void initCommonView() {
        //1.加载页面
        mLoadingView = View.inflate(UIUtils.getContext(), R.layout.pager_loading, null);
        this.addView(mLoadingView);
        //2.错误页面
        mErrorView = View.inflate(UIUtils.getContext(), R.layout.pager_error, null);
        this.addView(mErrorView);
        mErrorView.findViewById(R.id.bt_pager_error_retry).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                //重新触发加载数据
                loadData();
            }
        });

        //3.空页面
        mEmptyView = View.inflate(UIUtils.getContext(), R.layout.pager_empty, null);
        this.addView(mEmptyView);

    }

    // 数据加载的流程
    /**
     ① 触发加载  	进入页面开始加载/点击某一个按钮的时候加载
     ② 异步加载数据  -->显示加载视图
     ③ 处理加载结果
     ① 成功-->显示成功视图
     ② 失败
     ① 数据为空-->显示空视图
     ② 数据加载失败-->显示加载失败的视图
     */
    /**
     * @des 触发加载数据
     * @call 暴露给外界调用, 其实就是外界  触发加载数据
     */
    private void loadData() {

        //如果加载成功，或者正在加载中，就不需要再加载了
        if(mCurState !=STATE_SUCCESS && mCurState!=STATE_LOADING){

        }

    }
}
