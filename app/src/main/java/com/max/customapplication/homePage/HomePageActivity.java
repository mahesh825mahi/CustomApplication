package com.max.customapplication.homePage;

import android.os.Bundle;
import android.widget.Toast;

import com.max.customapplication.R;
import com.max.customapplication.framework.BaseActivity;
import com.max.customapplication.framework.network.model.CryptoData;

import java.util.List;

import javax.inject.Inject;

public class HomePageActivity extends BaseActivity implements HomePageView.View {
   @Inject
   HomePageView.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        component().addModule(new HomePageModule(this)).inject(this);
        mPresenter.loadData();
    }

    private void bindLocationListener() {
        //BoundGoogleAPIClient.bindGoogleAPIClientIn(this, mGpsListener, getApplicationContext());
    }

    @Override
    public void showData(List<CryptoData> data) {
        Toast.makeText(getApplicationContext(), "Hello Javatpoint----->" + data.size(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showError(String message) {

    }

    @Override
    public void showComplete() {

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }
}
