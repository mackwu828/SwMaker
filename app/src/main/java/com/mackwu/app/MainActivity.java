package com.mackwu.app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.mackwu.app.util.DisplayUtil;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //
        TextView tvTest = findViewById(R.id.tv_test);
        final Button btnTest = findViewById(R.id.btn_test);

        //
        String designWidth = "1920x1080";
        int width = DisplayUtil.getWidth(this);
        int height = DisplayUtil.getHeight(this);
        int smallestWidth = Math.min(width, height);
        int dpi = DisplayUtil.getDpi(this);
        String calculateSw = (int) (smallestWidth / (dpi / 160f)) + "dp";
        String currentSw = getResources().getString(R.string.current_sw);

        Log.d("TAG", "designWidth: " + designWidth);
        Log.d("TAG", "屏幕分辨率: " + width + "x" + height);
        Log.d("TAG", "dpi: " + dpi);
        Log.d("TAG", "计算的最小宽度: " + calculateSw);
        Log.d("TAG", "实际的最小宽度: " + currentSw);
        btnTest.post(() -> Log.d("TAG", btnTest.getWidth() + "px"));

    }
}
