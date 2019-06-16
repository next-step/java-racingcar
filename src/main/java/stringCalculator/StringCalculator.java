package stringCalculator;


import org.apache.commons.lang3.StringUtils;

import java.util.regex.Pattern;

public class StringCalculator {

    private final static String SPLIT_REGEX = " ";
    private final static int FRIST_NUMBER = 0;
    private final static int SECOND_NUMBER_INDEX = 1;
    private final static int CALCULATE_STEP = 2;

    private int total;
    private String inputFormula;
    private Calculator calculator;

    public StringCalculator(){
        calculator = new Calculator();
    }

    public void setFormula(String formula) {
        if(StringUtils.isEmpty(formula)) throw new IllegalArgumentException();
        verifyMathematicalSymbol(formula);
        this.inputFormula = formula;
    }

    public int getTotal() {
        calculate();
        return this.total;
    }

    private String[] split(String str) {
        return str.split(SPLIT_REGEX);
    }

    private StringCalculator calculate() {
        String[] strings = split(this.inputFormula);

        int firstNumber = Integer.parseInt(strings[FRIST_NUMBER]);
        calculator.initialize(firstNumber);

        for (int i = 1; i < strings.length; i+=CALCULATE_STEP) {
            String symbol = strings[i];
            int number = Integer.parseInt(strings[i + SECOND_NUMBER_INDEX]);
            calculator = calculates(symbol, number);
        }
        this.total = calculator.getTotal();
        return this;
    }

    private Calculator calculates(String symbol, int number) {
        if ("+".equals(symbol)) return calculator.add(number);
        if ("-".equals(symbol)) return calculator.subtract(number);
        if ("*".equals(symbol)) return calculator.multiply(number);
        if ("/".equals(symbol)) return calculator.divide(number);
        throw new IllegalArgumentException();
    }

    private void verifyMathematicalSymbol(String input) {
        Pattern pattern = Pattern.compile("[!@#$%^&(),.?\\\":{}|<>]");
        if(pattern.matcher(input).find()) throw new IllegalArgumentException("+, -, *, / 사칙연산 특수문자만 가능합니다.");
    }
}
