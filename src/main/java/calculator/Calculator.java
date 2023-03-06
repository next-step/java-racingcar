package calculator;

import static java.lang.Integer.parseInt;

public class Calculator {

    void inputCheck(String data){
        if (data == null || data.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    int calculate(String data) {

        String digitsRegex = "\\d";
        String notDigitRegex = "\\D";
        String[] formulaSign = data.replaceAll(digitsRegex, "").split("");
        String[] formulaNumber = data.split(notDigitRegex);
        int i = 0;
        int result = parseInt(formulaNumber[i]);

        inputCheck(data);

        for (String sg : formulaSign)
        {
            i++;
            result = calSub(sg, result, parseInt(formulaNumber[i]));
        }

        return result;
    }

    private int calSub(String sign, int i, int j){
        switch (sign) {
            case "+":
                return plus(i, j);
            case "-":
                return minus(i, j);
            case "*":
                return multi(i, j);
            case "/":
                return div(i, j);
            default : throw new IllegalArgumentException();
        }
    }

    int plus(int i, int j){
        return i + j;
    }
    int minus(int i, int j){
        return i - j;
    }
    int multi(int i, int j){
        return i * j;
    }
    int div(int i, int j){
        return i / j;
    }
}
