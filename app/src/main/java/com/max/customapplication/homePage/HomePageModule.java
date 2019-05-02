package com.max.customapplication.homePage;

import com.max.customapplication.framework.network.APIInterface;

import dagger.Module;
import dagger.Provides;

@Module
public class HomePageModule {

    private HomePageView.View mView;

    public HomePageModule(HomePageView.View mView) {
        this.mView = mView;
    }

    @Provides
    public HomePageView.Presenter providePresenter(APIInterface mApi) {
        return new HomePagePresenter(mView, mApi);
    }
}
