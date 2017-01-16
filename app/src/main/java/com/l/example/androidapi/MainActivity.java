package com.l.example.androidapi;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.l.example.androidapi.apis.ApiLeverActivity;

import butterknife.OnClick;

/**
 * 有关 android 的系统控件的使用，及不同版本 API 上的差异，如：android6.0 的权限问题
 */
public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView title = (TextView) findViewById(R.id.tv_top_middle);
        title.setText("androidAPI");
    }

    @OnClick({R.id.btn1})
    public void onclick(View view) {
        switch (view.getId()){
            case R.id.btn1:
                startActivity(new Intent(MainActivity.this,ApiLeverActivity.class));
                break;
        }

    }
}
