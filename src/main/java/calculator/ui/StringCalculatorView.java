package calculator.ui;

import calculator.domain.Operand;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringCalculatorView {

    private static final StringCalculatorView VIEW = new StringCalculatorView();

    private static final String EMPTY_EXPRESSION = "";

    private StringCalculatorView() {
    }

    public static StringCalculatorView getInstance() {
        return VIEW;
    }

    public String input() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            return br.readLine();
        } catch (IOException e) {
            return EMPTY_EXPRESSION;
        }
    }

    public void printResult(Operand result) {
        System.out.println(result.getValue());
    }
}
