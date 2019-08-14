package com.zyh.libone;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * @author ZhangYuhang
 * @date 2019/8/12
 * @updatelog
 */
public class LibOne2Activity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lb_one);
        ButterKnife.bind(this);

    }

}
