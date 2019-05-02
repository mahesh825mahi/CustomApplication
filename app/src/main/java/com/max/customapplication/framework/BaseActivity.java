package com.max.customapplication.framework;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.max.customapplication.framework.di.component.ApplicationComponent;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        component().inject(this);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {

        super.onBackPressed();
    }

    public ApplicationComponent component() {
        return ((BaseApplication) getApplication()).component();
    }
}
