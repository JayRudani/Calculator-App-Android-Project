package com.example.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView operation;
    TextView input;

    boolean isNew=true;
    boolean dot_pressed=false;
    boolean percentageNewNumber = false;
    boolean percentPreviousOperation = false;
    double percentPreviousOperationValue=0;
    String percentPreviousValue;
    String oldNumber;
    String op="";
    String wholeOperation="";
    double memoryValue=0;
    int i=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        operation = findViewById(R.id.op_details);
        input = findViewById(R.id.input_details);
    }

    public void clearOperation(View view) {
        i++;
        Handler handler = new Handler();
        Runnable r = new Runnable() {
            @Override
            public void run() {
                i = 0;
            }
        };
        if (i == 1) {
            //Single click
            input.setText("");
            handler.postDelayed(r, 300);
        } else if (i == 2) {
            //Double click
            i = 0;
            operation.setText("");
        }


    }

    public void numberInput(View view) {
        if(isNew)
            input.setText("");
        isNew=false;
        String number = input.getText().toString();
        switch(view.getId())
        {
            case R.id.button_0:
                number+="0";
                percentageNewNumber=true;
                break;
            case R.id.button_1:
                number+="1";
                percentageNewNumber=true;
                break;
            case R.id.button_2:
                number+="2";
                percentageNewNumber=true;
                break;
            case R.id.button_3:
                number+="3";
                percentageNewNumber=true;
                break;
            case R.id.button_4:
                number+="4";
                percentageNewNumber=true;
                break;
            case R.id.button_5:
                number+="5";
                percentageNewNumber=true;
                break;
            case R.id.button_6:
                number+="6";
                percentageNewNumber=true;
                break;
            case R.id.button_7:
                number+="7";
                percentageNewNumber=true;
                break;
            case R.id.button_8:
                number+="8";
                percentageNewNumber=true;
                break;
            case R.id.button_9:
                number+="9";
                percentageNewNumber=true;
                break;
            case R.id.button_dot:
                if(!dot_pressed) {
                    number += ".";
                    dot_pressed=true;
                    break;
                }
                else
                    break;
        }
        input.setText(number);
    }

    public void operationInput(View view) {
        isNew=true;
        dot_pressed=false;
        oldNumber = input.getText().toString();
        wholeOperation="";
        switch(view.getId()){
            case R.id.button_add:
                op="+";
                percentPreviousOperation=true;
                percentPreviousValue=oldNumber;
                wholeOperation+=oldNumber+op;
                break;
            case R.id.button_div:
                op="/";
                percentPreviousOperation=true;
                percentPreviousValue=oldNumber;
                wholeOperation+=oldNumber+op;
                break;
            case R.id.button_sub:
                op="-";
                percentPreviousOperation=true;
                percentPreviousValue=oldNumber;
                wholeOperation+=oldNumber+op;
                break;
            case R.id.button_mult:
                op="*";
                percentPreviousOperation=true;
                percentPreviousValue=oldNumber;
                wholeOperation+=oldNumber+op;
                break;
            case R.id.button_ex:
                op="^";
                percentPreviousOperation=true;
                wholeOperation+=oldNumber+op;
                break;
            case R.id.button_percentage:
                if(percentPreviousOperation)
                {
                    percentPreviousOperationValue=0;
                    wholeOperation=percentPreviousValue+op+oldNumber+"%";
                    percentPreviousOperationValue=Calculator.moduloPreviousOperation(op,percentPreviousValue,oldNumber);
                }
                op = "%";
                //wholeOperation+=oldNumber+op;
                percentageNewNumber = false;
                break;
        }

    }

    public void equalEvent(View view) {
        dot_pressed=false;
        String newNumber = input.getText().toString();
        double result=0;
        switch(op){
            case "+":
                result=Calculator.add(oldNumber,newNumber);
                wholeOperation+=newNumber;
                break;
            case "-":
                result=Calculator.sub(oldNumber,newNumber);
                wholeOperation+=newNumber;
                break;
            case "/":
                result=Calculator.div(oldNumber,newNumber);
                wholeOperation+=newNumber;
                break;
            case "*":
                result=Calculator.mult(oldNumber,newNumber);
                wholeOperation+=newNumber;
                break;
            case"^":
                result=Calculator.exponent(oldNumber,newNumber);
                wholeOperation+=newNumber;
                break;
            case "%":
                if(percentPreviousOperation)
                {
                    result=percentPreviousOperationValue;
                }
                else if(percentageNewNumber){
                    result=Calculator.modulo(oldNumber,newNumber);
                    wholeOperation+=newNumber;
                }
                else
                    result=Double.parseDouble(oldNumber)/100;
                break;
        }
        operation.setText(wholeOperation);
        input.setText(result+"");
    }

    public void memoryOperation(View view) {
        isNew=true;
        dot_pressed=false;
        oldNumber = input.getText().toString();
        switch(view.getId()){
            case R.id.button_Madd:
                memoryValue=Calculator.Madd(memoryValue,oldNumber);
                break;
            case R.id.button_Msub:
                memoryValue=Calculator.Msub(memoryValue,oldNumber);
                break;
            case R.id.button_MS:
                memoryValue=Double.parseDouble(oldNumber);
                break;
            case R.id.button_MC:
                memoryValue=0;
                break;
            case R.id.button_MR:
                input.setText(memoryValue+"");
                break;
        }
    }
}