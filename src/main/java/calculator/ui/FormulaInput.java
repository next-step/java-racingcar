package calculator.ui;

import calculator.util.FormulaUtil;
import calculator.util.IsValidInput;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FormulaInput {

    public static List<String> getFormula() {
        List<String> formular = new ArrayList<>();
        System.out.println("계산할 연산식을 입력해주세요.");
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            String input = bufferedReader.readLine();
            IsValidInput.isBlankOrNot(input);
            formular = FormulaUtil.split(input);
            IsValidInput.isNotOperator(formular);
            IsValidInput.isNotNumber(formular);
        } catch (IllegalArgumentException | IOException e) {
            System.out.println("[ERROR] " + e.getMessage());
        }
        return formular;
    }

}
