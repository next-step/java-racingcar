package calculator;
import jdk.nashorn.internal.runtime.regexp.joni.Regex;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculatorString {

    private static final String WHITESPACE= " ";

    public int stringCalculator(String input) {

        String[] strings = stringParser(input);
        int total = parserInt(strings[0]);

        for (int index = 1; index < strings.length; index += 2) {

            CalculatorSymbol calculatorSymbol = new CalculatorSymbol();
            int secondNum = parserInt(strings[index + 1]);

            switch (strings[index]) {
                case "+":
                     total  = calculatorSymbol.add(total, secondNum);
                     break;
                case "-":
                    total =   calculatorSymbol.subtract(total, secondNum);
                    break;
                case "*":
                    total =   calculatorSymbol.multiply(total, secondNum);
                    break;
                case "/":
                    total =   calculatorSymbol.division(total, secondNum);
                    break;
                default :
                    throw new IllegalArgumentException("calculatorsymbol is error");
            }
        }
        return total;
    }

    public int parserInt(String word) {

        if(!word.matches("^[0-9]+$")) {
            throw new IllegalArgumentException("해당 문자는 숫자가 아닙니다.");
        }
        return Integer.parseInt(word);

    }

    public String[] stringParser(String input) {
        return Optional.ofNullable(input)
                .filter(i -> !i.trim().isEmpty())
                .map(i -> input.split(WHITESPACE))
                .orElseThrow(IllegalArgumentException::new);
    }
}
