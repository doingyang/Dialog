package com.project.ydy.dialog.dialog;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Window;
import android.view.WindowManager;

import com.project.ydy.dialog.R;

/**
 * **************************************************
 * 文件名称 : BaseDialogFragment
 * 作    者 : Created by ydy
 * 创建时间 : 2018/7/9 9:48
 * 文件描述 :
 * 注意事项 :
 * 修改历史 : 2018/7/9 1.00 初始版本
 * **************************************************
 */
public class BaseDialogFragment extends DialogFragment {

    @NonNull
    @Override
    public LayoutInflater onGetLayoutInflater(@Nullable Bundle savedInstanceState) {
        setStyle(DialogFragment.STYLE_NORMAL, R.style.DialogFullScreen);
        super.onGetLayoutInflater(savedInstanceState);

        LayoutInflater layoutInflater = getActivity().getLayoutInflater();
        if (!getDialog().getWindow().isFloating()) {
            setupDialog();
            layoutInflater = new DialogLayoutInflater(getActivity(), layoutInflater,
                    new DialogFrameLayout.OnOutSideTouchListener() {
                        @Override
                        public void onOutSideTouch() {
                            if (isCancelable()) {
                                dismiss();
                            }
                        }
                    });
        }
        return layoutInflater;
    }

    protected void setupDialog() {
        Window window = getDialog().getWindow();
        /*//状态栏
        setStatusBarTranslucent(window, true);
        setStatusBarColor(window, Color.TRANSPARENT, false);*/

        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        getDialog().setOnKeyListener(new DialogInterface.OnKeyListener() {
            @Override
            public boolean onKey(DialogInterface dialogInterface, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_UP && keyCode == KeyEvent.KEYCODE_BACK) {
                    if (isCancelable()) {
                        dismiss();
                    }
                    return true;
                }
                return false;
            }
        });
    }
}
