package caculator;

import java.util.Iterator;
import java.util.List;

import static java.lang.Integer.parseInt;

public class Caculator {
    private static final String DEFAULT_DELIMITER = " ";
    private String[] inputList ;
    private float result;

    public float caculator(String input) {
        validate(input);
        inputList = input.split(DEFAULT_DELIMITER);
        result = 0;
        String sign = "";
        for(String string : inputList) {
            sign = calculatorWithSign(string, sign);
        }
        return result;
    }

    private String calculatorWithSign(String input, String sign) {
        int number = 0;
        try {
            number = parseInt(input);
            result = innerCaclurator(number, result, sign);
        } catch (NumberFormatException e) {
            sign = input;
        }
        return sign;
    }
    private void validate(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("입력 값이 null 이거나 비어있습니다.");
        }
    }

    private float innerCaclurator(int number, float result, String sign) {
        if (sign.equals("+"))
            return sum(result, number);
        if (sign.equals("-"))
            return sub(result, number);
        if (sign.equals("/"))
            return divide(result, number);
        if (sign.equals("*"))
            return multi(result, number);
        if (sign.equals(""))
            return number;
        throw new IllegalArgumentException("사칙연산 기호가 아닙니다");
    }

    float sum(float a, float b) {
        return a+b;
    }

    float sub(float a, float b) {
        return a-b;
    }

    float multi(float a, float b) {
        return a*b;
    }

    float divide(float a, float b) {
        float c = 0;
        if ( b!= 0 )
           c = a/b;
        return c;
    }

}
