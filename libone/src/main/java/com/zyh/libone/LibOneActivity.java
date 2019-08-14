package com.zyh.libone;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.github.mzule.activityrouter.annotation.Router;
import com.github.mzule.activityrouter.router.Routers;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2019/4/18.
 * 类描述：业务组件
 */
@Router("lib1")
public class LibOneActivity extends AppCompatActivity {

    @BindView(R2.id.edittext)
    EditText edittext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lb_one);
        ButterKnife.bind(this);

    }

    @OnClick({R2.id.btn_app, R2.id.btn_tolib2, R2.id.btn_toapp_param,R2.id.btn_toapp_more_param})
    public void onViewClicked(View view) {
        int i = view.getId();
        if (i == R.id.btn_app) {
            Toast.makeText(this, "jjj", Toast.LENGTH_SHORT).show();
            Routers.open(this, "zyh://main");
        } else if (i == R.id.btn_tolib2) {
            Routers.open(this, "zyh://lib2");
        } else if (i == R.id.btn_toapp_param) {
            Routers.open(this, "zyh://main/" + edittext.getText().toString());
        }else if (i==R.id.btn_toapp_more_param){
            Routers.open(this, "zyh://main/张三/男/26");
//            startActivity(new Intent(LibOneActivity.this,LibOne2Activity.class));
        }

    }
}
