package com.max.customapplication.homePage;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.max.customapplication.R;
import com.max.customapplication.framework.BaseActivity;
import com.max.customapplication.framework.network.model.CryptoData;

import java.util.List;

import javax.inject.Inject;

public class HomePageActivity extends BaseActivity implements HomePageView.View, View.OnClickListener {
   @Inject
   HomePageView.Presenter mPresenter;
    Button mMakeApiCall;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        component().addModule(new HomePageModule(this)).inject(this);
        mMakeApiCall =(Button) findViewById(R.id.makeApiCall);

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

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.makeApiCall:
            mPresenter.loadData();
            break;
        }
    }
}
