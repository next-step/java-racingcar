package calculator.view;

import calculator.domain.StringCalculator;

import java.util.Scanner;

public class CalculateInputView {
    private static final String INPUT_CALCULATE_MESSAGE = "숫자와 사칙연산(+,-,*,/)을 공백 구분으로 입력해주세요 (EX : 1 + 1, 2 / 1 )";
    private static final Scanner SCANNER = new Scanner(System.in);

    public static StringCalculator getStringCalculator() {
        try {
            System.out.println(INPUT_CALCULATE_MESSAGE);
            return new StringCalculator(SCANNER.nextLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getStringCalculator();
        }
    }
}
