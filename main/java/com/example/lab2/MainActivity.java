package com.example.lab2;

import android.icu.text.DateFormat;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.*;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    Button badd, bcancel, bclear, binc, bdec;
    TextView tvoutcome, tvuptop, tvint;
    EditText editText;
    RadioButton rbmale, rbfemale, rbengineer;
    String print, radiostring;
    private static final String TAG = "MainActivity";
    Boolean check = false;
    CounterLogic counter = new CounterLogic();
    int mainint;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // assignments
        badd = (Button) findViewById(R.id.badd);
        bcancel = (Button) findViewById(R.id.bcancel);
        bclear = (Button) findViewById(R.id.bclear);
        editText = (EditText) findViewById(R.id.editText);
        tvoutcome = (TextView) findViewById(R.id.tvoutcome);
        rbengineer = (RadioButton) findViewById(R.id.rbengineer);
        rbfemale = (RadioButton) findViewById(R.id.rbfemale);
        rbmale = (RadioButton) findViewById(R.id.rbmale);
        binc = (Button) findViewById(R.id.binc);
        bdec = (Button) findViewById(R.id.bdec);
        tvint = (TextView) findViewById(R.id.tvint);
        // on click listener fold edittext input
        badd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                print = "null";
                print = editText.getText().toString();
                if (print != "null" && check) {
                    tvoutcome.setText(radiostring+print+" added");
                    tvoutcome.setVisibility(View.VISIBLE); //poistetaan ehkä myöhemmin!!!!!
                }
            }
        });
        onClearClick();
        // cancel
        bcancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(1);
            }
        });
        // counter
        binc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int temp = mainint;
                temp = counter.incrementShort(mainint);
                mainint = temp;
                String mainstring = Integer.toString(mainint);
                tvint.setText(mainstring);
            }
        });
        binc.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                int temp = mainint;
                temp = counter.incrementLong(mainint);
                mainint = temp;
                String mainstring = Integer.toString(mainint);
                tvint.setText(mainstring);
                return true;
            }
        });
        bdec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int temp = mainint;
                temp = counter.decrementShort(mainint);
                mainint = temp;
                String mainstring = Integer.toString(mainint);
                tvint.setText(mainstring);
            }
        });
        bdec.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                int temp = mainint;
                temp = counter.decrementLong(mainint);
                mainint = temp;
                String mainstring = Integer.toString(mainint);
                tvint.setText(mainstring);
                return true;
            }
        });
    }
    public void onRadioButtonClicked(View v) {
        boolean checked = ((RadioButton) v).isChecked();
        // check which button is pressed
        switch(v.getId()) {
            case R.id.rbmale:
                if (checked)
                    Log.i(TAG, check.toString());
                    check = true;
                    radiostring = "Male ";
                break;
            case R.id.rbfemale:
                if (checked)
                    check = true;
                    radiostring = "Female ";
                break;
            case R.id.rbengineer:
                if (checked)
                    check = true;
                    radiostring = "Engineer ";
                break;
        }
    }
    public void onClearClick() {
        bclear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText("");
                tvoutcome.setText("");
                check = false;
                rbmale.setChecked(false);
                rbengineer.setChecked(false);
                rbfemale.setChecked(false);
                check = false;
                print = "null";
                mainint = 0;
                tvint.setText("0");
            }
        });
    }
    public class CounterLogic {
        private int mainint = 0;
        // constructor
        public CounterLogic() {
        };
        public int incrementShort(int startingpoint) {
            if (startingpoint >= 5) {
                startingpoint = 5;
                return startingpoint;
            }
            else {
                startingpoint++;
                mainint = startingpoint;
                return mainint;
            }
        }
        public int incrementLong(int startingpoint) {
            if (startingpoint >= 4) {
                return startingpoint;
            }
            else {
                startingpoint=startingpoint+2;
                mainint = startingpoint;
                return mainint;
            }
        }
        public int decrementShort(int startingpoint) {
            if (startingpoint == 0) {
                return startingpoint;
            }
            else {
                startingpoint--;
                mainint = startingpoint;
                return mainint;
            }
        }
        public int decrementLong(int startingpoint) {
            if (startingpoint <= 1) {
                return startingpoint;
            }
            else {
                startingpoint=startingpoint-2;
                mainint = startingpoint;
                return mainint;
            }
        }
    }
}
