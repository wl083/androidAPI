package com.l.example.androidapi.apis;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.l.example.androidapi.BaseActivity;
import com.l.example.androidapi.Constants;
import com.l.example.androidapi.R;

import butterknife.OnClick;

/**
 * Created by Administrator on 2017/1/13.
 * 有关 android 的系统控件的使用，及不同版本 API 上的差异，如：android6.0 的权限问题
 */
public class ApiLeverActivity extends BaseActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_api_lever);
        TextView title = (TextView) findViewById(R.id.tv_top_middle);
        title.setText("androidAPI");
    }

    @OnClick({R.id.btn1,R.id.btn2})
    public void onclick(View view) {
        switch (view.getId()){
            //TODO # 拨打电话
            case R.id.btn1:
                if (hasPermission(Manifest.permission.CALL_PHONE)){
                    Log.i(TAG, "可使用拨号功能");
                    callPhone();
                }else {
                    Log.i(TAG, "不可使用拨号功能");
                    reRequestPermission(Constants.PHOTO_CODE,Manifest.permission.CALL_PHONE);
                }
                break;
            //TODO # 访问 SD 卡
            case R.id.btn2:
                if (hasPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)){
                    visitSDcard();
                }else {
                    reRequestPermission(Constants.WRITE_EXTRNAL_STORAGE_CODE,Manifest.permission.WRITE_EXTERNAL_STORAGE);
                }
                break;
        }

    }


    /**
     * # 拨打电话
     */
    public void callPhone(){
        //直接使用 Intent.ACTION_CALL 在6.0以上的版本中会蹦掉，建议使用 ACTION_DIAL
        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:666666"));
        startActivity(intent);
    }


    /**
     * 访问 SD 卡
     */
    public void visitSDcard(){

    }

    /**
     *
     * @param requestCode
     * @param permissions
     * @param grantResults
     */
    @Override
    protected void doRequestPermission(int requestCode, String[] permissions, int[] grantResults) {
        super.doRequestPermission(requestCode, permissions, grantResults);
        if (requestCode == Constants.PHOTO_CODE){
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED){
                callPhone();
            }else {
                showToast("已拒绝拨号功能",ApiLeverActivity.this);
            }
        }
        if (requestCode == Constants.WRITE_EXTRNAL_STORAGE_CODE){
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED){
                visitSDcard();
            }else {
                showToast("已拒绝访问SD卡功能",ApiLeverActivity.this);
            }
        }
    }
}
