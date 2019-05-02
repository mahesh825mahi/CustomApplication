package com.max.customapplication.homePage;
import com.max.customapplication.framework.network.APIInterface;
import com.max.customapplication.framework.network.model.CryptoData;
import java.util.List;
import javax.inject.Inject;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
public class HomePagePresenter implements HomePageView.Presenter {
    private final HomePageView.View mView;

    private final APIInterface mApi;
    @Inject
    public HomePagePresenter(HomePageView.View mView,APIInterface mApi) {
        this.mView = mView;
        this.mApi = mApi;
    }
    @Override
    public void loadData() {
        mView.showProgress();

        mApi.getData("10").subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<CryptoData>>() {
                    @Override
                    public void onCompleted() {
                        mView.showComplete();
                        mView.hideProgress();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showError("Error occurred");
                        mView.hideProgress();
                    }

                    @Override
                    public void onNext(List<CryptoData> data) {
                        mView.showData(data);
                    }
                });
    }
}
