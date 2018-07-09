package com.project.ydy.dialog;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.project.ydy.dialog.dialog.BaseDialogFragment;

/**
 * **************************************************
 * 文件名称 : CommDialog
 * 作    者 : Created by ydy
 * 创建时间 : 2018/7/9 9:20
 * 文件描述 :
 * 注意事项 :
 * 修改历史 : 2018/7/9 1.00 初始版本
 * **************************************************
 */
public class CommDialog extends BaseDialogFragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.dialog_comm, container, false);
    }

}
