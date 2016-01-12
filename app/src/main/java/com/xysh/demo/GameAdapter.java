package com.xysh.demo;

import android.content.Context;
import android.widget.ImageView;

import com.joanzapata.android.BaseAdapterHelper;
import com.joanzapata.android.QuickAdapter;

/**
 * Created by Administrator on 2016/1/12.
 */
public class GameAdapter extends QuickAdapter<gamebean> {
    private ImageView imageView;
    public GameAdapter(Context context, int layoutResId) {
        super(context, layoutResId);
    }

    @Override
    protected void convert(BaseAdapterHelper helper, gamebean item) {
    }
}
