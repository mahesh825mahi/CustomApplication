package com.max.customapplication.homePage;

import com.max.customapplication.framework.di.scopes.ActivityScope;

import dagger.Subcomponent;

@ActivityScope
@Subcomponent(modules = HomePageModule.class)
public interface HomePageComponent {
    void inject(HomePageActivity mainActivity);
}
