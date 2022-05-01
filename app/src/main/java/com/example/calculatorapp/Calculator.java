package com.example.calculatorapp;

public class Calculator {

    public static double add(String oldNumber, String newNumber){
        return (Double.parseDouble(oldNumber)+Double.parseDouble(newNumber));
    }
    public static double mult(String oldNumber, String newNumber){
        return (Double.parseDouble(oldNumber)*Double.parseDouble(newNumber));
    }
    public static double div(String oldNumber, String newNumber){
        return (Double.parseDouble(oldNumber)/Double.parseDouble(newNumber));
    }
    public static double sub(String oldNumber, String newNumber){
        return (Double.parseDouble(oldNumber)-Double.parseDouble(newNumber));
    }
    public static double exponent(String oldNumber, String newNumber){
        return (Math.pow(Double.parseDouble(oldNumber),Double.parseDouble(newNumber)));
    }
    public static double modulo(String oldNumber, String newNumber){
        return (Double.parseDouble(oldNumber)*(Double.parseDouble(newNumber)/100));
    }
    public static double Madd(double memoryValue, String oldNumber){
        return (memoryValue+Double.parseDouble(oldNumber));
    }
    public static double Msub(double memoryValue, String oldNumber){
        return (memoryValue-Double.parseDouble(oldNumber));
    }
    public static double moduloPreviousOperation(String op,String percentPreviousValue, String oldNumber){
        if(op=="*")
            return (Double.parseDouble(percentPreviousValue)*(Double.parseDouble(oldNumber)/100));
        else if(op=="+")
            return (Double.parseDouble(percentPreviousValue)+(Double.parseDouble(oldNumber)*(Double.parseDouble(oldNumber)/100)));
        else if(op=="-")
            return (Double.parseDouble(percentPreviousValue)-(Double.parseDouble(oldNumber)*(Double.parseDouble(oldNumber)/100)));
        else
            return (Double.parseDouble(percentPreviousValue)/(Double.parseDouble(oldNumber)/100));
    }
}
