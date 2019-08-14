package com.zyh.componentdemo;

import com.github.mzule.activityrouter.annotation.Module;

/**
 * Created by Administrator on 2019/4/25.
 * 类描述：每个 module(包含主项目) 都要添加一个 @Module(name) 的注解在任意类上面（最好是一个新建的类，作为标志类，空类即可），name 是项目的名称
 */
@Module("app")
public class AppModule {
}
