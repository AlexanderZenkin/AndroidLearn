package com.example.myapplication;

public class LogicCalc {
    Float result;

    public Float logicCalc(String taskOperation, float numberInputOne, float numberInputTwo) {
        switch (taskOperation) {
            case "+":
                result = (numberInputOne + numberInputTwo);
                MainActivity.correctOperation = true;
                break;
            case "-":
                result = numberInputOne - numberInputTwo;
                MainActivity.correctOperation = true;
                break;
            case "*":
                result = (numberInputOne * numberInputTwo);
                MainActivity.correctOperation = true;
                break;
            case "/":
                if (numberInputTwo == 0) throw new ArithmeticException();
                result = (numberInputOne / numberInputTwo);
                MainActivity.correctOperation = true;
                break;
            case "%":
                result = (numberInputOne % numberInputTwo);
                MainActivity.correctOperation = true;
                break;
            default:
                MainActivity.correctOperation = false;
                break;
        }
        return result;
    }
}
