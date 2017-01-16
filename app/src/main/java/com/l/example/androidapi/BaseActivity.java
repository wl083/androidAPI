package com.l.example.androidapi;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import butterknife.ButterKnife;

//import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/1/13.
 */
public class BaseActivity extends AppCompatActivity {

    protected String TAG = "wl";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().hide();
        ButterKnife.bind(this);
    }

    /**
     * 判断是有权限
     *
     * @param permissions
     * @return
     */
    protected boolean hasPermission(String... permissions) {

        for (String permission : permissions) {
            if (ContextCompat.checkSelfPermission(this, permission) !=
                    PackageManager.PERMISSION_GRANTED) {
                return false;
            }
        }
        return true;
    }

    /**
     * @param code
     * @param permissions
     */
    protected void reRequestPermission(int code, String... permissions) {
        ActivityCompat.requestPermissions(this, permissions, code);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//        switch (requestCode){
//            case Constants.CAMER_CODE:
//                break;
//            case Constants.PHOTO_CODE:
//                break;
//            case Constants.READ_EXTRAL_STORAGE_CODE:
//                break;
//            case Constants.WRITE_EXTRNAL_STORAGE_CODE:
//                break;
//            default:doPermission(requestCode,permissions,grantResults);
//        }
        doRequestPermission(requestCode, permissions, grantResults);
    }


    /**
     * 请求权限
     */
    protected void doRequestPermission(int requestCode, String[] permissions, int[] grantResults) {
    }

    /**
     *
     * @param msg
     * @param context
     */
    protected void showToast(String msg, Context context){
        Toast.makeText(context,msg,Toast.LENGTH_SHORT).show();
    }
}
