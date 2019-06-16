package stringCalculator;


import org.apache.commons.lang3.StringUtils;

import java.util.regex.Pattern;

public class StringCalculator {

    private final static String DELIMITER = " ";
    private final static int FRIST_NUMBER = 0;
    private final static int CALCULATE_STEP = 2;

    private int total;

    public StringCalculator(){
        this.total = 0;
    }

    public int getTotal() {
        return this.total;
    }

    private String[] split(String str) {
        return str.split(DELIMITER);
    }

    public StringCalculator calculate(String inputFormula) {
        if(StringUtils.isEmpty(inputFormula)) throw new IllegalArgumentException();
        verifyMathematicalSymbol(inputFormula);
        String[] strings = split(inputFormula);

        int total = Integer.parseInt(strings[FRIST_NUMBER]);

        for (int i = 1; i < strings.length; i+=CALCULATE_STEP) {
            String symbol = strings[i];
            int number = stringConvertToInt(strings[i + 1]);
            CalculateOperator selectedOperator = CalculateOperator.getOperatorBySymbol(symbol);
            total = selectedOperator.calculate(total, number);
        }
        this.total = total;
        return this;
    }

    private int stringConvertToInt(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 계산식 입니다.");
        }
    }

    private void verifyMathematicalSymbol(String input) {
        Pattern pattern = Pattern.compile("[!@#$%^&(),.?\\\":{}|<>]");
        if(pattern.matcher(input).find()) throw new IllegalArgumentException("+, -, *, / 사칙연산 특수문자만 가능합니다.");
    }
}
