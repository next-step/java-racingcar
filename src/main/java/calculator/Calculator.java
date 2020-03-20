package calculator;

import java.util.Arrays;
import java.util.List;

public class Calculator {

    public static void main(String[] args) {
        String input = getInputList();
    }

    private static String getInputList() {
        return InputView.getInput();
    }

    public int calculate(String s) {
        return Integer.MAX_VALUE;
    }
}
