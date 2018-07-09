package com.project.ydy.dialog.dialog;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

/**
 * **************************************************
 * 文件名称 : DialogFrameLayout
 * 作    者 : Created by ydy
 * 创建时间 : 2018/7/9 9:41
 * 文件描述 :
 * 注意事项 :
 * 修改历史 : 2018/7/9 1.00 初始版本
 * **************************************************
 */
public class DialogFrameLayout extends FrameLayout {

    GestureDetector gestureDetector = null;

    interface OnOutSideTouchListener {
        /**
         * 外部触摸事件
         */
        void onOutSideTouch();
    }

    OnOutSideTouchListener onOutSideTouchListener;

    public void setOnOutSideTouchListener(OnOutSideTouchListener onOutSideTouchListener) {
        this.onOutSideTouchListener = onOutSideTouchListener;
    }

    public DialogFrameLayout(@NonNull Context context) {
        super(context);
        init(context);
    }

    private void init(@NonNull Context context) {
        gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {

            @Override
            public boolean onDown(MotionEvent e) {
                return true;
            }

            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                Rect rect = new Rect();
                getHitRect(rect);
                int count = getChildCount();
                for (int i = count - 1; i > -1; i--) {
                    View child = getChildAt(i);
                    Rect outRect = new Rect();
                    child.getHitRect(outRect);
                    if (outRect.contains((int) e.getX(), (int) e.getY())) {
                        return false;
                    }
                }
                if (onOutSideTouchListener != null) {
                    onOutSideTouchListener.onOutSideTouch();
                }
                return true;
            }
        });
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return gestureDetector.onTouchEvent(event);
    }
}
