package calculator.ui;

import calculator.domain.Formula;
import calculator.util.Console;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FormulaInput {

    private FormulaInput() {
    }

    public static Formula getFormula() {
        Formula formular = null;
        System.out.println("계산할 연산식을 입력해주세요.");
        try {
            String input = Console.readLine();
            isBlankOrNot(input);

            formular = new Formula(input);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
            return getFormula();
        }
        return formular;
    }

    private static void isBlankOrNot(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("입력값이 Null이거나 빈 공백 문자입니다!");
        }
    }
}
