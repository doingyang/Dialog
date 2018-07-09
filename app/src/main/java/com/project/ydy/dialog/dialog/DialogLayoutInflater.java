package com.project.ydy.dialog.dialog;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * **************************************************
 * 文件名称 : DialogLayoutInflater
 * 作    者 : Created by ydy
 * 创建时间 : 2018/7/9 9:45
 * 文件描述 :
 * 注意事项 :
 * 修改历史 : 2018/7/9 1.00 初始版本
 * **************************************************
 */
public class DialogLayoutInflater extends LayoutInflater {

    private LayoutInflater layoutInflater;

    private DialogFrameLayout.OnOutSideTouchListener listener;

    public DialogLayoutInflater(Context context, LayoutInflater layoutInflater, DialogFrameLayout.OnOutSideTouchListener listener) {
        super(context);
        this.layoutInflater = layoutInflater;
        this.listener = listener;
    }

    @Override
    public LayoutInflater cloneInContext(Context context) {
        return layoutInflater.cloneInContext(context);
    }

    @Override
    public View inflate(int resource, @Nullable ViewGroup root, boolean attachToRoot) {
        DialogFrameLayout dialogFrameLayout = new DialogFrameLayout(getContext());
        dialogFrameLayout.setOnOutSideTouchListener(listener);
        dialogFrameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        layoutInflater.inflate(resource, dialogFrameLayout, true);
        return dialogFrameLayout;
    }
}
