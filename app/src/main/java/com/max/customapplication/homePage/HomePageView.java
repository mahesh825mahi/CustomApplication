package com.max.customapplication.homePage;

import com.max.customapplication.framework.network.model.CryptoData;

import java.util.List;

public interface HomePageView {
    interface View {
        void showData(List<CryptoData> data);

        void showError(String message);

        void showComplete();

        void showProgress();

        void hideProgress();
    }

    interface Presenter {
        void loadData();
    }
}
