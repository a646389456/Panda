package com.example.lenovo.pandas;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Login extends Activity
{
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    public void playGame(View v)
    {
        Intent intent = new Intent( Login.this,FirstPass.class);
        startActivity(intent);
        finish();
    }

    public void ruleState(View v)
    {
        String[] rules = {"游戏共设置五关", "每关限制2分钟", "每关均2次机会，找到熊猫图案即通过"};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        //设置对话框标题
        builder.setTitle("游戏规则");
        //设置对话框图标
        builder.setIcon(R.drawable.panda_11);
        //设置列表式规则内容
        builder.setItems(rules, null);
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {

            }
        }).create().show();
    }
}
