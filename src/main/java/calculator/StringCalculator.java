package calculator;

import java.util.HashMap;
import java.util.Map;

public class StringCalculator {


    private static final Map<String,String> regexGroups = new HashMap<>();
    private static final String STRING_SEPARATOR = " ";

    public StringCalculator() {
        regexGroups.put("number","^[0-9]*$");
        regexGroups.put("special_characters","^[^a-zA-Z0-9가-힣]");
    }

    private String getType(String input) {
        return regexGroups.entrySet()
                .stream()
                .filter(entry -> input.matches(entry.getValue()))
                .map(Map.Entry::getKey)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(CalculatorError.E002));
    }

    private void isEmpty(String value) {
        if(value == null || value.isEmpty() || value.trim().length() == 0) {
            throw new IllegalArgumentException(CalculatorError.E003);
        }
    }

    private void expressionCheck(String[] valueArr) {

        if(!getType(valueArr[0]).equals("number")) {
            throw new IllegalArgumentException(CalculatorError.E004);
        }

        if(getType(valueArr[valueArr.length-1]).equals("special_characters")) {
            throw new IllegalArgumentException(CalculatorError.E005);
        }
    }

    private String[] split(String expression) {
        isEmpty(expression);
        String[] expArr = expression.split(STRING_SEPARATOR);
        expressionCheck(expArr);

        return expArr;
    }

    public int result(String input) {
        String[] inputArr = split(input);

        int resultNum = Integer.parseInt(inputArr[0]);

        for (int i = 1; i < inputArr.length; i += 2) {
            String op = inputArr[i];
            int secondNum = Integer.parseInt(inputArr[i + 1]);
            Operator operator = Operator.validationCheck(op);
            resultNum = operator.calculate(resultNum,secondNum,op);
        }

        return resultNum;
    }

}
