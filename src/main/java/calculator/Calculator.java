package calculator;

import static java.lang.Integer.parseInt;

public class Calculator {

    void inputCheck(String data){
        if(data == null || data.isEmpty()) throw new IllegalArgumentException();
    }

    int calculator(String data) {

        inputCheck(data);

        String[] sign = data.replaceAll("[0-9]", "").split("");
        String[] number = data.split("[^0-9]");
        int i = 0;
        int result = parseInt(number[i]);

        for(String sg : sign)
        {
            i++;
            result = calSub(sg, result, parseInt(number[i]));
        }
        return result;
    }

    int calSub(String sign, int i, int j){
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
        return i += j;
    }
    int minus(int i, int j){
        return i -= j;
    }
    int multi(int i, int j){
        return i *= j;
    }
    int div(int i, int j){
        return i /= j;
    }
}
