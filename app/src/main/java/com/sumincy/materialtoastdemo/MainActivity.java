package com.sumincy.materialtoastdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.sumincy.materialtoast.MToast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.top).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MToast.makeText(MainActivity.this, "hello").show();
            }
        });

        findViewById(R.id.bottom).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MToast.makeText(MainActivity.this, "hello", R.style.bottom_style).show();
            }
        });

        findViewById(R.id.left).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MToast.makeText(MainActivity.this, "hello", R.style.left_style).show();
            }
        });

        findViewById(R.id.right).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MToast.makeText(MainActivity.this, "hello", R.style.right_style).show();
            }
        });


        findViewById(R.id.scale).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MToast.makeText(MainActivity.this, "hello", R.style.scale_style).show();
            }
        });

        findViewById(R.id.iamge_layout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MToast.makeText(MainActivity.this, "", R.style.image_layout_style).show();
            }
        });


    }
}
