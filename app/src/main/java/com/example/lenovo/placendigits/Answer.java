package com.example.lenovo.placendigits;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by Lenovo on 21-10-2016. */

public class Answer extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.answer);
        Intent act=getIntent();
        long score=10000000;
        int cha=act.getIntExtra("chance",0);
        long clock=act.getLongExtra("clock",0);
        score=(score/clock)/cha;
        TextView temp=(TextView)findViewById(R.id.textview8);
        temp.setText(":"+score);
    }
}
