package com.xu.kevin.toolbaralphabehavior;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Window;

public class MainActivity extends AppCompatActivity {
    private ToolBarAlphaBehavior toolBarAlphaBehavior;
    private Toolbar toolbar;
    private CustomNestedScrollView mScrollView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mScrollView=(CustomNestedScrollView)findViewById(R.id.scrollView);
        initToolBar();
    }

    private void initToolBar(){
        toolbar=(Toolbar)findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.draw_back);
        setSupportActionBar(toolbar);
        toolbar.setTitle("");
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        int imageViewHeight=dip2px(360);
        //toolBar变色回调
        toolBarAlphaBehavior = new ToolBarAlphaBehavior(getBaseContext(),toolbar, "000000", new ToolBarAlphaBehavior.CallBack() {
            @Override
            public void callBack(int color) {
                setStatuBarColor(color);
            }
        },imageViewHeight);

        //初始化toolBar 颜色
        toolBarAlphaBehavior.setAlPha(ToolBarAlphaBehavior.minAlpha);//toolbar透明度初始化

        //监听 NestScrollView
        mScrollView.setOnCustomScroolChangeListener(new CustomNestedScrollView.ScrollInterface() {
            @Override
            public void onSChanged(int l, int t, int oldl, int oldt) {
                //渐变色.
                if (toolBarAlphaBehavior != null)
                    toolBarAlphaBehavior.onNestedScroll(t);
            }
        });
    }

    public  void setStatuBarColor( int color) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = this.getWindow();
            window.setStatusBarColor(color);
        }
    }

    public  int dip2px( float dpValue) {
        final float scale =this.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
}
