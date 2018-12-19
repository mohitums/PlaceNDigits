package com.example.lenovo.placendigits;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Chronometer;
import  android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.ListView;
import java.util.ArrayList;

/**
 * Created by Lenovo on 11-10-2016.
 */

public class Display extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display);
        n1=(NumberPicker)findViewById(R.id.num1);
        n2=(NumberPicker)findViewById(R.id.num2);
        n3=(NumberPicker)findViewById(R.id.num3);
        n4=(NumberPicker)findViewById(R.id.num4);
        n1.setMaxValue(9);
        n2.setMaxValue(9);
        n3.setMaxValue(9);
        n4.setMaxValue(9);

        n1.setMinValue(0);
        n2.setMinValue(0);
        n3.setMinValue(0);
        n4.setMinValue(0);

        n1.setValue(1);
        n2.setValue(2);
        n3.setValue(3);
        n4.setValue(4);

        n1.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS);
        n2.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS);
        n3.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS);
        n4.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS);
        usr = (TextView) findViewById(R.id.t1);


        n1.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {

                usr.setText(picker.getValue()+""+n2.getValue()+""+n3.getValue()+n4.getValue());
            }
        });
        n2.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                usr.setText(n1.getValue()+""+picker.getValue()+""+n3.getValue()+n4.getValue());
            }
        });
        n3.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                usr.setText(n1.getValue()+""+n2.getValue()+""+picker.getValue()+n4.getValue());
            }
        });
        n4.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                usr.setText(n1.getValue() + "" + n2.getValue() + "" + n3.getValue() + picker.getValue());
            }
        });

    }
    int j,z,flag=-1,cows=0,bulls=0;
    int k=0,chance=0;
    String[] str=new String[50];
    NumberPicker n1,n2,n3,n4=null;
    Chronometer c1;
    long clock=0;
   TextView usr;

    public void dispno(View a)
    {
        Intent i=getIntent();
        int ansval=i.getIntExtra("value",0);
        c1=(Chronometer)findViewById(R.id.chronometer2);
        if(k==0)
        {
            c1.setBase(SystemClock.elapsedRealtime());
            c1.start();
        }


        if(a.getId()==R.id.g1) {

            check(ansval);
            populatelisview();
            if (bulls == 4) {
                c1.stop();
                clock = (SystemClock.elapsedRealtime() - c1.getBase()) / 1000;
                Intent act = new Intent(Display.this, Answer.class);
                act.putExtra("clock", clock);
                act.putExtra("chance", chance);
                startActivity(act);
            }

            //        TextView t2=(TextView)findViewById(R.id.test1);

          //  t.setText("" + n1.getValue() + "" + n2.getValue() + "" + n3.getValue() + "" + n4.getValue());
            //t2.setText(""+ansval);
            // t.setText(""+clock);


        }
    }

    private void check(int ansval) {
        int numb[]=new int[4];
        numb[3]=ansval%10;
        ansval=ansval/10;
        numb[2]=ansval%10;
        ansval=ansval/10;
        numb[1]=ansval%10;
        ansval=ansval/10;
        numb[0]=ansval%10;


        int guess[]=new int[4];

        guess[0]=n1.getValue();
        guess[1]=n2.getValue();
        guess[2]=n3.getValue();
        guess[3]=n4.getValue();
        int flag=0;
       /* if(guess[0]==guess[1]||guess[0]==guess[2]||guess[0]==guess[3]||guess[1]==guess[2]||guess[1]==guess[3]||guess[2]==guess[3])
        {
            TextView t=(TextView)findViewById(R.id.t1);
            t.setText(""+"Number Repeated");
        }*/



            cows = 0;
            bulls = 0;
            for (z = 0; z < 4; z++) {
                flag = -1;

                for (j = 0; j < 4; j++) {
                    if (numb[z] == guess[j]) {
                        if (z == j) {
                            bulls++;
                            flag = 1;
                        } else {
                            cows++;
                            flag = 1;
                        }

                    }
                    if (flag == 1) {
                        break;
                    }
                }
            }
            chance++;

            if (k < 9) {
                str[k] = "\t\t\t\t\t\t\t\t" + chance + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + cows + "\t\t\t\t\t" + "\t\t\t\t\t\t\t\t\t" + bulls + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + n1.getValue() + n2.getValue() + n3.getValue() + n4.getValue();
                k++;
            } else {
                str[k] = "\t\t\t\t\t\t\t" + chance + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + cows + "\t\t\t\t\t" + "\t\t\t\t\t\t\t\t\t" + bulls + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + n1.getValue() + n2.getValue() + n3.getValue() + n4.getValue();
                k++;
            }

    }


    private void populatelisview() {
        String apple[]=new String[k];
        int l1=0;
        for(l1=0;l1<k;l1++)
        {
            apple[l1]=str[l1];
        }
        ArrayAdapter<String> adapter=new ArrayAdapter<>(this,R.layout.listview_test,apple);
        ListView list=(ListView)findViewById(R.id.lv1);
        list.setAdapter(adapter);
    }

}
