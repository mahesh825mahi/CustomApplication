package com.max.customapplication.framework.di.component;

import com.max.customapplication.framework.BaseActivity;
import com.max.customapplication.framework.BaseApplication;
import com.max.customapplication.homePage.HomePageComponent;
import com.max.customapplication.homePage.HomePageModule;

public interface BaseApplicationComponent {
    void inject(BaseApplication baseApplication);

    void inject(BaseActivity baseActivity);

    HomePageComponent addModule(HomePageModule module);
}
