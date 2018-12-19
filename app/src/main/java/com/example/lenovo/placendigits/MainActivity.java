package com.example.lenovo.placendigits;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void ongen(View v) {
        int j = 100;
        Random r = new Random();
        int d1 = r.nextInt(9);
        int d2 = r.nextInt(9);
        int d3 = r.nextInt(9);
        int d4 = r.nextInt(9);
        while (d1 == d2 || d1 == d3 || d1 == d4 || d2 == d3 || d2 == d4 || d3 == d4) {
            if (d1 == d2 || d2 == d3 || d2 == d4) {
                d2 = r.nextInt(9);
            }
            if (d1 == d3 || d2 == d3 || d3 == d4) {
                d3 = r.nextInt(9);
            }
            if (d1 == d4 || d2 == d4 || d3 == d4) {
                d4 = r.nextInt(9);
            }
        }
        int ans = (d4 + (d3 * 10) + (d2 * 100) + (d1 * 1000));
        if (v.getId() == R.id.n1) {
            Intent i = new Intent(MainActivity.this, Display.class);
            i.putExtra("value", ans);
            startActivity(i);

        }
    }

    public void develop(View view) {
        if (view.getId() == R.id.d1) {
            Intent act = new Intent(MainActivity.this, Developer.class);
            startActivity(act);
        }
    }
    public void rule(View v1){
        if(v1.getId()==R.id.n2)
        {
            Intent a1=new Intent(MainActivity.this,Ruler.class);
            startActivity(a1);
        }
    }
}