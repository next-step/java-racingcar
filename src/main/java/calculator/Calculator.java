package calculator;

import java.util.Arrays;

public class Calculator {

    public int calculatorByString() {

        String input = "2 + 3 * 4 / 2";

        String [] convertInput = input.split(" ");

        int result = 0;
        for (int i = 0; i < convertInput.length; i++) {
            if (i == 0) { result = Integer.parseInt(convertInput[i]); }

            if (isSigned(convertInput[i])) {
                result = getCalc(result, Integer.parseInt(convertInput[i+1]), convertInput[i]);
            }
        }

        return result;
    }

    private int getCalc(int i, int j, String sign) {
        int returnVal;

        switch (sign) {
            case "*": returnVal = i * j; break;
            case "+": returnVal = i + j; break;
            case "-": returnVal = i - j; break;
            case "/": returnVal = i / j; break;
            default: returnVal = i; break;
        }

        return returnVal;
    }

    private boolean isSigned(String sign) {
        if (sign.equals("*") || sign.equals("+") || sign.equals("-") || sign.equals("/")) {
            return true;
        } else {
            return false;
        }
    }
}
