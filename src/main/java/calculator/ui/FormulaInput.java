package calculator.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FormulaInput {

    public String getFormula() {
        String input = "";
        System.out.println("계산할 연산식을 입력해주세요.");
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            input = bufferedReader.readLine();
        } catch (IllegalArgumentException | IOException e) {
            System.out.println("[ERROR]");
            getFormula();
        }
        return input;
    }
}
