package com.zyh.libtwo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.github.mzule.activityrouter.annotation.Router;
import com.github.mzule.activityrouter.router.Routers;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2019/4/25.
 * 类描述：业务组件
 */
@Router("lib2")
public class LibTwoActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lib_two);
        ButterKnife.bind(this);
    }


    @OnClick({R2.id.btn_tolib1, R2.id.btn_toapp})
    public void onViewClicked(View view) {
        int i = view.getId();
        if (i == R.id.btn_tolib1) {
            Routers.open(this, "zyh://lib1");
        } else if (i == R.id.btn_toapp) {
            Routers.open(this, "zyh://main");
        }
    }
}
