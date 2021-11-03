package com.kakao.calculator;

import com.kakao.calculator.domain.StringCalculator;
import com.kakao.calculator.ui.View;

public class Runner {
    public static void main(String args[]){
        String input = View.inputExpression(System.in);
        double calculate = new StringCalculator().calculate(input);
        System.out.println(calculate);
    }
}
