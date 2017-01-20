package com.example.calc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.*;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList array1 = new ArrayList();
    ArrayList<Integer> array2 = new ArrayList<Integer>();
    Button bone, btwo, bthree, bfour, bfive, bsix, bseven, beight, bnine, bzero, bplus, bequals;
    TextView tvdisplay;
    String TAG = "MyActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bone = (Button) findViewById(R.id.bone);
        btwo = (Button) findViewById(R.id.btwo);
        bthree = (Button) findViewById(R.id.bthree);
        bfour = (Button) findViewById(R.id.bfour);
        bfive = (Button) findViewById(R.id.bfive);
        bsix = (Button) findViewById(R.id.bsix);
        bseven = (Button) findViewById(R.id.bseven);
        beight = (Button) findViewById(R.id.beight);
        bnine = (Button) findViewById(R.id.bnine);
        bzero = (Button) findViewById(R.id.bzero);
        bplus = (Button) findViewById(R.id.bplus);
        bequals = (Button) findViewById(R.id.bequals);
        tvdisplay = (TextView) findViewById(R.id.tvdisplay);
        /*bone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClick1(v);
            }
        });*/
        bone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                array1.add(1);
                tvdisplay.setText(tvdisplay.getText().toString()+"1");
            }
        });
        btwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                array1.add(2);
                tvdisplay.setText(tvdisplay.getText().toString()+"2");
            }
        });
        bthree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                array1.add(3);
                tvdisplay.setText(tvdisplay.getText().toString()+"3");
            }
        });
        bfour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                array1.add(4);
                tvdisplay.setText(tvdisplay.getText().toString()+"4");
            }
        });
        bfive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                array1.add(5);
                tvdisplay.setText(tvdisplay.getText().toString()+"5");
            }
        });
        bsix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                array1.add(6);
                tvdisplay.setText(tvdisplay.getText().toString()+"6");
            }
        });
        bseven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                array1.add(7);
                tvdisplay.setText(tvdisplay.getText().toString()+"7");
            }
        });
        beight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                array1.add(8);
                tvdisplay.setText(tvdisplay.getText().toString()+"8");
            }
        });
        bnine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                array1.add(9);
                tvdisplay.setText(tvdisplay.getText().toString()+"9");
            }
        });
        bzero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                array1.add(0);
                tvdisplay.setText(tvdisplay.getText().toString()+"0");
            }
        });
        bplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = "";
                int x = 0;
                for (int i = 0 ; i < array1.size(); ++i) {
                    str = str+array1.get(i).toString();
                    x = Integer.parseInt(str);
                }
                array2.add(x);
                tvdisplay.setText(str+" + ");
                Log.i(TAG, "ekan arrayn str to in tulos on: "+x);
                array1.clear();
            }
        });
        bequals.setOnClickListener(new View.OnClickListener() {
            int sum=0;
            @Override
            public void onClick(View v) {
                String str = "";
                int x = 0;
                for (int i = 0 ; i < array1.size(); ++i) {
                    str = str+array1.get(i).toString();
                    x = Integer.parseInt(str);
                }
                array2.add(x);
                array1.clear();
                for (int i=0; i < array2.size(); i++) {
                    sum = sum + array2.get(i);
                }
                String strsum = Integer.toString(sum);
                tvdisplay.setText(strsum);
                Log.i(TAG, "tokan arrayn summa on :"+strsum);
                array2.clear();
            }
        });
    }
    /*public void onClick1(View v) {
        bone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                array.add(1);
                tvdisplay.setText(tvdisplay.getText().toString()+" 1");
            }
        });
    }*/

}
