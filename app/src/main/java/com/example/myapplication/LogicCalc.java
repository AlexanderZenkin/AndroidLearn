package com.example.myapplication;

public class LogicCalc {
    float result;

    public float logicCalc(String taskOperation, float numberInputOne, float numberInputTwo) {
        var mainActivity = new MainActivity();

        switch (taskOperation) {
            case "+":
                result = numberInputOne + numberInputTwo;
                mainActivity.correctOperation = true;
                break;
            case "-":
                result = numberInputOne - numberInputTwo;
                mainActivity.correctOperation = true;
                break;
            case "*":
                result = numberInputOne * numberInputTwo;
                mainActivity.correctOperation = true;
                break;
            case "/":
                if (numberInputTwo == 0) throw new ArithmeticException();
                result = numberInputOne / numberInputTwo;
                mainActivity.correctOperation = true;
                break;
            default:
                mainActivity.correctOperation = false;
                break;
        }
        return result;
    }
}
