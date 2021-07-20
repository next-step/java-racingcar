package calculator;

import calculator.utils.CalculatorUtil;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import calculator.utils.StringUtil;

public class StringCalculator {

    private static final Pattern OPERAND_REGEX = Pattern.compile("[0-9]");
    private static final Pattern OPERATOR_REGEX = Pattern.compile("[+\\-*/]");

    private ArrayList<Integer> operandList = new ArrayList<>();
    private ArrayList<String> operatorList = new ArrayList<>();


    public void checkValidity(String[] expressions) {
        int expressionLen = expressions.length;

        if(expressionLen % 2 == 0){
            throw new IllegalArgumentException("유효한 연산식이 아닙니다.");
        }

        for (int i = 0; i < expressionLen; i++) {

            if (i % 2 == 0) {
                if(!isOperand(expressions[i])){
                    throw new IllegalArgumentException("유효한 피연산자 형식이 아닙니다.");
                }
                operandList.add(Integer.parseInt(expressions[i]));
            }

            if (i % 2 == 1) {
                if(!isOperator(expressions[i])) {
                    throw new IllegalArgumentException("유효한 연산자 형식이 아닙니다.");
                }
                operatorList.add(expressions[i]);

            }
        }
    }

    public boolean isOperand(String operand) {
        Matcher matches = OPERAND_REGEX.matcher(operand);

        if (matches.find()) {
            return true;
        }

        return false;
    }

    public boolean isOperator(String operator) {
        Matcher matches = OPERATOR_REGEX.matcher(operator);

        if (matches.find()) {
            return true;
        }

        return false;
    }

    public int calculateExpression() {

        int result = operandList.get(0);

        for (int i = 0; i < operatorList.size(); i++) {
            String operator = operatorList.get(i);
            int operand = operandList.get(i+1);
            result = CalculatorUtil.calculate(operator, result, operand);
        }

        return result;

    }

    public int execute(String expression) {
        StringUtil.checkBlank(expression);
        checkValidity(StringUtil.split(expression));

        return calculateExpression();
    }

}
