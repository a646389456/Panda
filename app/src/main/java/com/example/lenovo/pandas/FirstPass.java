package com.example.lenovo.pandas;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Application;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Chronometer;
import android.widget.Toast;

public class FirstPass extends Activity
{

    int times = 3;
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        Chronometer chronometer = (Chronometer) findViewById(R.id.chronometer);
        chronometer.setBase(SystemClock.elapsedRealtime());
        chronometer.start();
        chronometer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener()
        {
            @Override
            public void onChronometerTick(Chronometer chronometer)
            {
                if(SystemClock.elapsedRealtime() - chronometer.getBase() > 120 * 1000)
                {
                    chronometer.stop();
                    builder.setTitle("游戏结束");
                    builder.setIcon(R.drawable.panda_01);
                    builder.setMessage("已超出规定时间(〃＞皿＜)");
                    builder.setPositiveButton("确定", new DialogInterface.OnClickListener()
                    {
                        public void onClick(DialogInterface dialog, int which)
                        {
                           finish();
                        }
                    }).create().show();
                }
            }
        });
    }
    public void answerPass(View v)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("已通关");
        builder.setIcon(R.drawable.panda_01);
        builder.setMessage("恭喜找到熊猫^_^");
        builder.setPositiveButton("下一关", new DialogInterface.OnClickListener()
        {
            public void onClick(DialogInterface dialog, int which)
            {
               Intent intent  = new Intent(FirstPass.this, SecondPass.class);
               startActivity(intent);
               finish();
            }
        }).create().show();
    }

    public void notPass(View v)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        times--;
        if(times == 0)
        {
            builder.setTitle("游戏结束");
            builder.setIcon(R.drawable.panda_01);
            builder.setMessage("未找到熊猫(⊙︿⊙)");
            builder.setPositiveButton("确定", new DialogInterface.OnClickListener()
            {
                public void onClick(DialogInterface dialog, int which)
                {
                    finish();
                }
            }).create().show();
           return;
        }
        Toast.makeText(FirstPass.this,"未找到熊猫，还剩" + (times - 1) + "次机会", Toast.LENGTH_SHORT).show();
    }
}
