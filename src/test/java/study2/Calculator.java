package study2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;

@DisplayName("2단계 - 문자열 계산기")
public class Calculator {

    @ParameterizedTest
    @ValueSource(strings = {"2 + 3 * 4 / 2 - 5"})
    void stringCalculatorTest(String inputString) {

        ArrayList<String> calculatorArrayList = new ArrayList<>();
        calculatorArrayList = getCalculatorArrayList(inputString);
        String operator = "";
        Integer result = 0;
        for (String contents : calculatorArrayList) {
            if (contents.equals("+") ||
                    contents.equals("-") ||
                    contents.equals("*") ||
                    contents.equals("/")) {
                operator = contents;
            } else {
                switch (operator) {
                    case "+":
                        result = computePlus(result, Integer.parseInt(contents));
                        operator = "";
                        break;
                    case "-":
                        result = computerMinus(result, Integer.parseInt(contents));
                        operator = "";
                        break;
                    case "*":
                        result = computerMultiply(result, Integer.parseInt(contents));
                        operator = "";
                        break;
                    case "/":
                        result = computerDivide(result, Integer.parseInt(contents));
                        operator = "";
                        break;
                    default:
                        result = Integer.parseInt(contents);
                        break;
                }
            }
        }
        
        System.out.println("result = " + result);
    }

    Integer computePlus(Integer number1, Integer number2) {
        return number1 + number2;
    }

    Integer computerMinus(Integer number1, Integer number2) {
        return number1 - number2;
    }

    Integer computerMultiply(Integer number1, Integer number2) {
        return number1 * number2;
    }

    Integer computerDivide(Integer number1, Integer number2) {
        return number1 / number2;
    }
    
    ArrayList<String> getCalculatorArrayList(String inputString) {
        char[] inputCharArray = inputString.replace(" ", "").toCharArray();

        validateInputChars(inputCharArray);

        ArrayList<String> returnArrayList = new ArrayList<String>();

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < inputCharArray.length; i++) {
            char c = inputCharArray[i];

            if (isOperator(String.valueOf(c))) {
                if (stringBuilder.length() > 0) {
                    returnArrayList.add(stringBuilder.toString());
                    stringBuilder.setLength(0);
                    returnArrayList.add(String.valueOf(c));
                } else {
                    throw new IllegalArgumentException();
                }
            } else {
                stringBuilder.append(c);
            }
        }

        if (stringBuilder.length() > 0) {
            returnArrayList.add(stringBuilder.toString());
        }

        return returnArrayList;
    }

    boolean isNumber(String str) {
        return str.matches("^[0-9]*$");
    }

    boolean isOperator(String str) {
        return str.matches("^[+-/*]$");
    }

    void validateInputString(String str) {

        if (!isNumber(str) && !isOperator(str)) {
            throw new IllegalArgumentException();
        }
    }

    void validateInputChars(char[] chars) {

        if (chars.length == 0) {
            throw new IllegalArgumentException();
        }

        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            validateInputString(String.valueOf(aChar));
        }
    }
}
