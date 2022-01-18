package calculator.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FormulaInput {

    public static String getFormula() {
        String input = "";
        System.out.println("계산할 연산식을 입력해주세요.");
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            input = bufferedReader.readLine();
            isBlankOrNot(input);
        } catch (IllegalArgumentException | IOException e) {
            System.out.println("[ERROR]");
            getFormula();
        }
        return input;
    }

    private static void isBlankOrNot(String input) {
        if (input == null || "".equals(input)) {
            throw new IllegalArgumentException("입력값이 Null이거나 빈 공백 문자입니다!");
        }
    }
}
