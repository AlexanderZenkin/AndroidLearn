package com.example.myapplication;

import java.math.BigDecimal;

public class LogicCalc {
    BigDecimal result;

    public BigDecimal logicCalc(String taskOperation, float numberInputOne, float numberInputTwo) {
        var mainActivity = new MainActivity();

        switch (taskOperation) {
            case "+":
                result = BigDecimal.valueOf(numberInputOne + numberInputTwo);
                mainActivity.correctOperation = true;
                break;
            case "-":
                result = BigDecimal.valueOf(numberInputOne - numberInputTwo);
                mainActivity.correctOperation = true;
                break;
            case "*":
                result = BigDecimal.valueOf(numberInputOne * numberInputTwo);
                mainActivity.correctOperation = true;
                break;
            case "/":
                if (numberInputTwo == 0) throw new ArithmeticException();
                result = BigDecimal.valueOf(numberInputOne / numberInputTwo);
                mainActivity.correctOperation = true;
                break;
            default:
                mainActivity.correctOperation = false;
                break;
        }
        return result;
    }
}
