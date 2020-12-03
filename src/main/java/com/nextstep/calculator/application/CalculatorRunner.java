package com.nextstep.calculator.application;

import com.nextstep.calculator.domain.Calculator;
import com.nextstep.calculator.domain.CalculatorFactory;

import java.util.Scanner;

public class CalculatorRunner {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String INPUT_COMMENT = "계산할 수식을 입력해주세요.";
    private static final String RESULT_HEADER = "결과는 다음과 같습니다: ";

    public static void main(String [] args) {
        System.out.println(INPUT_COMMENT);
        String userFormula = SCANNER.nextLine();

        Calculator calculator = CalculatorFactory.of(userFormula);

        System.out.println(RESULT_HEADER + calculator.calculate().getValue());
    }
}
