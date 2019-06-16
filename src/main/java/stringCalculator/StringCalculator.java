package stringCalculator;


import org.apache.commons.lang3.StringUtils;

import java.util.regex.Pattern;

public class StringCalculator {

    private final static String SPLIT_REGEX = " ";
    private final static int FRIST_NUMBER = 0;
    private final static int SECOND_NUMBER_INDEX = 1;
    private final static int CALCULATE_STEP = 2;

    private int total;
    private Calculator calculator;

    public StringCalculator(){
        calculator = new Calculator();
    }

    public int getTotal() {
        return this.total;
    }

    private String[] split(String str) {
        return str.split(SPLIT_REGEX);
    }

    public StringCalculator calculate(String inputFormula) {
        if(StringUtils.isEmpty(inputFormula)) throw new IllegalArgumentException();
        verifyMathematicalSymbol(inputFormula);
        String[] strings = split(inputFormula);

        int firstNumber = Integer.parseInt(strings[FRIST_NUMBER]);
        calculator.initialize(firstNumber);

        for (int i = 1; i < strings.length; i+=CALCULATE_STEP) {
            String symbol = strings[i];
            int number = stringConvertToInt(strings[i + SECOND_NUMBER_INDEX]);
            calculator = calculates(symbol, number);
        }
        this.total = calculator.getTotal();
        return this;
    }

    private int stringConvertToInt(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 계산식 입니다.");
        }
    }

    private Calculator calculates(String symbol, int number) {
        if ("+".equals(symbol)) return calculator.add(number);
        if ("-".equals(symbol)) return calculator.subtract(number);
        if ("*".equals(symbol)) return calculator.multiply(number);
        if ("/".equals(symbol)) return calculator.divide(number);
        throw new IllegalArgumentException("옳바른 계산식이 아닙니다.");
    }

    private void verifyMathematicalSymbol(String input) {
        Pattern pattern = Pattern.compile("[!@#$%^&(),.?\\\":{}|<>]");
        if(pattern.matcher(input).find()) throw new IllegalArgumentException("+, -, *, / 사칙연산 특수문자만 가능합니다.");
    }
}
