package calculator.view;

import calculator.domain.Formula;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FormulaInput {

    private FormulaInput() {
    }

    public static Formula inputFormula() {
        System.out.println("계산할 연산식을 입력해주세요.");
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            String input = br.readLine();
            isBlankOrNot(input);

            return new Formula(input);
        } catch (IllegalArgumentException | IOException e) {
            System.out.println("[ERROR] " + e.getMessage());
            return inputFormula();
        }
    }

    private static void isBlankOrNot(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("입력값이 Null이거나 빈 공백 문자입니다!");
        }
    }
}
