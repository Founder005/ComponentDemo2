package com.zyh.componentdemo;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.github.mzule.activityrouter.annotation.Router;
import com.github.mzule.activityrouter.router.Routers;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

@Router({"main", "main/:name", "main/:name/:sex/:age"})
public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tv_name)
    TextView tvName;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mContext = this;
        tvName.setText(getIntent().getStringExtra("name"));
        tvName.setText(getIntent().getStringExtra("name")+getIntent().getStringExtra("sex")+getIntent().getStringExtra("age"));
    }

    @OnClick({R.id.btn_normal, R.id.btn_lib1, R.id.btn_lib2, R.id.btn_lib3})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_normal:
                Toast.makeText(this, "jjj", Toast.LENGTH_SHORT).show();
//                startActivity(new Intent(mContext, LibOneActivity.class));
                break;
            case R.id.btn_lib1:
                Routers.open(mContext, "zyh://lib1");
                break;
            case R.id.btn_lib2:
                Routers.open(mContext, "zyh://lib2");
                break;
            case R.id.btn_lib3:
                //方法一
                //第三个参数是RouterCallback，可以实现跳转前后和失败未找到的操作，前提是MyApplication直接实现RouterCallback接口，
                //或者创建一个类实现RouterCallbackProvider返回RouterCallbackProvider实例，然后在此处new出来
                Routers.open(mContext, "zyh://lib3", MyApplication.getInstance());
                //方法二
                //可以通过跳转到RouterActivity来进行跳转，前提是MyApplication实现RouterCallbackProvider接口并在provideRouterCallback返回RouterCallback实例
//                Intent intent = new Intent();
//                intent.setClass(this,RouterActivity.class);
//                intent.setData(Uri.parse("zyh://lib3"));
//                startActivity(intent);
                break;
        }
    }

}
