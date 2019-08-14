package com.zyh.componentdemo;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import com.github.mzule.activityrouter.annotation.Modules;
import com.github.mzule.activityrouter.router.RouterCallback;

/**
 * Created by Administrator on 2019/4/18.
 * 类描述：这是壳app 不单独运行
 */
@Modules({"app","libone", "libtwo"})
public class MyApplication extends Application implements RouterCallback {

    public static final MyApplication INSTANCE = new MyApplication();

    public MyApplication() {
    }

    public static MyApplication getInstance() {
        return INSTANCE;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public void notFound(Context context, Uri uri) {
        context.startActivity(new Intent(context, NotFoundActivity.class));
    }

    @Override
    public boolean beforeOpen(Context context, Uri uri) {
//        context.startActivity(new Intent(context, LaunchActivity.class));
        // 是否拦截，true 拦截，false 不拦截
        return false;
    }

    @Override
    public void afterOpen(Context context, Uri uri) {


    }

    @Override
    public void error(Context context, Uri uri, Throwable e) {
        context.startActivity(new Intent(context, NotFoundActivity.class));
    }

    //
//    @Override
//    public RouterCallback provideRouterCallback() {
//        return new SimpleRouterCallback(){
//            @Override
//            public void notFound(Context context, Uri uri) {
//                context.startActivity(new Intent(context, NotFoundActivity.class));
//            }
//
//            @Override
//            public boolean beforeOpen(Context context, Uri uri) {
//                return super.beforeOpen(context, uri);
//            }
//
//            @Override
//            public void afterOpen(Context context, Uri uri) {
//                super.afterOpen(context, uri);
//            }
//
//            @Override
//            public void error(Context context, Uri uri, Throwable e) {
//                super.error(context, uri, e);
//            }
//        };
//    }
}
