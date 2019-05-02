package com.max.customapplication.framework;
import android.app.Application;
import com.max.customapplication.framework.di.component.ApplicationComponent;
public abstract class BaseApplication extends Application {

    private ApplicationComponent mApplicationComponent;
    protected abstract ApplicationComponent createApplicationComponent();

    @Override
    public void onCreate() {
        super.onCreate();

        initialiseLibraries();
    }

    private void initialiseLibraries() {
        mApplicationComponent = createApplicationComponent();
        mApplicationComponent.inject(BaseApplication.this);
    }

    public ApplicationComponent component() {
        return mApplicationComponent;
    }
}
