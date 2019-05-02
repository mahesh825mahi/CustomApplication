package com.max.customapplication.framework;

import com.max.customapplication.framework.di.component.ApplicationComponent;
import com.max.customapplication.framework.di.component.DaggerApplicationComponent;
import com.max.customapplication.framework.di.module.AndroidModule;

public class CustomApplication extends BaseApplication {
    @Override
    protected ApplicationComponent createApplicationComponent() {
        return DaggerApplicationComponent.builder()
                .androidModule(new AndroidModule(this))
                .build();
    }
}
