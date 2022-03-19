package com.hujunyao.cumtcal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.hujunyao.cumtcal.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    public static native String trans(String str);

    // Used to load the 'cumtcal' library on application startup.

    static {
        System.loadLibrary("cumtcal");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        com.hujunyao.cumtcal.databinding.ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        EditText et = binding.etInput;
        Button btn = binding.btnRun;
        TextView tv = binding.tvOutput;

        Toast.makeText(this, "1+2*3;", Toast.LENGTH_SHORT).show();
//        System.out.println(trans("1+2*3;"));
        Toast.makeText(this, "???", Toast.LENGTH_SHORT).show();
        btn.setOnClickListener(view -> tv.setText(trans(String.valueOf(et.getText()))));
    }

}

