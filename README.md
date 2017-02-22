ToolBarAlphaBehavior
==================

Android - ToolBarAlphaBehavior

## Demo

![ToolBarAlphaBehavior GIF](./blobs/demo.gif)


## How to Use

```groovy
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
```




