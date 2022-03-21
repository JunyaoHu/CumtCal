package com.hujunyao.cumtcal;

import android.annotation.SuppressLint;
import android.content.pm.ApplicationInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.hujunyao.cumtcal.databinding.ActivityMainBinding;

import java.util.Random;


public class MainActivity extends AppCompatActivity {
    public static native String calc(String str);

    static {
        System.loadLibrary("cumtcal");
    }


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        com.hujunyao.cumtcal.databinding.ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Random r = new Random();
        EditText et = binding.etInput;
        Button btn_run = binding.btnRun;
        TextView tv_output = binding.tvOutput;
        Button btn_gesture = binding.btnGesture;
        Button btn_picture = binding.btnPicture;
        Button btn_random = binding.btnRandom;
        Button btn_send = binding.btnSend;
        TextView tv_ready = binding.tvReady;
        
        Button btn_add = binding.btnAdd;
        Button btn_sub = binding.btnSub;
        Button btn_mul= binding.btnMul;
        Button btn_div= binding.btnDiv;
        Button btn_left1 = binding.btnLeft1;
        Button btn_right1 = binding.btnRight1;
        Button btn_left2 = binding.btnLeft2;
        Button btn_right2 = binding.btnRight2;
        Button btn_sep = binding.btnSep;
        Button btn_fin = binding.btnFin;
        Button btn_ac = binding.btnAc;
        Button btn_del = binding.btnDel;


        Toast.makeText(this, "1+2*3;", Toast.LENGTH_SHORT).show();
        btn_run.setOnClickListener(view -> tv_output.setText(calc(String.valueOf(et.getText()))));
        btn_random.setOnClickListener(view->tv_ready.setText("" + r.nextInt(100)));
        btn_send.setOnClickListener(view -> et.setText(String.valueOf(et.getText()) + String.valueOf(tv_ready.getText())));

        btn_add.setOnClickListener(view -> et.setText(String.valueOf(et.getText()) + "+"));
        btn_sub.setOnClickListener(view -> et.setText(String.valueOf(et.getText()) + "-"));
        btn_mul.setOnClickListener(view -> et.setText(String.valueOf(et.getText()) + "*"));
        btn_div.setOnClickListener(view -> et.setText(String.valueOf(et.getText()) + "/"));
        btn_left1.setOnClickListener(view -> et.setText(String.valueOf(et.getText()) + "("));
        btn_right1.setOnClickListener(view -> et.setText(String.valueOf(et.getText()) + ")"));
        btn_left2.setOnClickListener(view -> et.setText(String.valueOf(et.getText()) + "{"));
        btn_right2.setOnClickListener(view -> et.setText(String.valueOf(et.getText()) + "}"));
        btn_sep.setOnClickListener(view -> et.setText(String.valueOf(et.getText()) + ","));
        btn_fin.setOnClickListener(view -> et.setText(String.valueOf(et.getText()) + ";"));
        btn_ac.setOnClickListener(view -> et.setText(""));
        btn_del.setOnClickListener(view -> {
            int len = et.length();
            if (len > 0) et.setText(String.valueOf(et.getText()).substring(0, len-1));
        });
        btn_picture.setOnClickListener(view-> {
            try {
                PostMethod.httpPost();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });



//                view -> et.setText(String.valueOf(et.getText()).substring(0, et.length()-1)));



    }

    public Bitmap getRes(String name) {
        ApplicationInfo appInfo = getApplicationInfo();
        int resID = getResources().getIdentifier(name, "drawable", appInfo.packageName);
        return BitmapFactory.decodeResource(getResources(), resID);
    }
}