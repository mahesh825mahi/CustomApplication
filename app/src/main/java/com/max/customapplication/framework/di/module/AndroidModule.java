package com.max.customapplication.framework.di.module;

import android.app.Application;
import android.content.res.Resources;
import android.provider.Settings.Secure;
import android.util.DisplayMetrics;

import com.max.customapplication.framework.di.qualifier.DeviceId;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AndroidModule {

    private Application mApplication;

    public AndroidModule(Application application) {
        this.mApplication = application;
    }

    public AndroidModule(Application application, Boolean isRegistered) {
        this.mApplication = null;
    }

    @Provides
    @Singleton
    public Application provideApplication() {
        return mApplication;
    }

    @Provides
    @Singleton
    public Resources provideResources() {
        return mApplication.getResources();
    }

    @Provides
    @Singleton
    public DisplayMetrics provideDisplayMetrics() {
        return new DisplayMetrics();
    }

    @Provides
    @Singleton
    @DeviceId
    public String provideDeviceId(Application application) {
        return Secure.getString(application.getContentResolver(), Secure.ANDROID_ID);
    }
}