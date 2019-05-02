package com.max.customapplication.framework.di.component;
import com.max.customapplication.framework.di.module.AndroidModule;
import com.max.customapplication.framework.di.module.RetrofitModule;
import javax.inject.Singleton;
import dagger.Component;
@Singleton
@Component(modules = {AndroidModule.class, RetrofitModule.class})
public interface ApplicationComponent extends BaseApplicationComponent {

}
