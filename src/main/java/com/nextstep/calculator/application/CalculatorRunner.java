package com.nextstep.calculator.application;

import com.nextstep.calculator.domain.Calculator;
import com.nextstep.calculator.domain.CalculatorFactory;

import java.util.Scanner;

public class CalculatorRunner {
    private final static Scanner SCANNER = new Scanner(System.in);

    public static void main(String [] args) {
        System.out.println("계산할 수식을 입력해주세요.");
        String userFormula = SCANNER.nextLine();

        Calculator calculator = CalculatorFactory.of(userFormula);

        System.out.println("결과는 다음과 같습니다: " + calculator.calculate().getValue());
    }
}
