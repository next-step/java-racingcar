package calculator.service;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import calculator.operator.Operator;
import calculator.utils.StringUtil;

public class StringCalculator {

    private static final Pattern OPERAND_REGEX = Pattern.compile("[0-9]");
    private static final Pattern OPERATOR_REGEX = Pattern.compile("[+\\-*/]");
    private static final Integer EXPRESSION_SEPARATOR = 2;

    private ArrayList<Integer> operandList = new ArrayList<>();
    private ArrayList<String> operatorList = new ArrayList<>();


    public void checkValidity(String[] expressions) {
        if(expressions.length % EXPRESSION_SEPARATOR == 0){
            throw new IllegalArgumentException("유효한 연산식이 아닙니다.");
        }

        for (int i = 0; i < expressions.length; i++) {
            separateExpressions(i,expressions[i]);
        }
    }

    public void separateExpressions(int index, String splitExpression){

        if (index % EXPRESSION_SEPARATOR == 0) {
            isOperand(splitExpression);
        }
        if (index % EXPRESSION_SEPARATOR == 1) {
            isOperator(splitExpression);
        }
    }

    public void isOperand(String operand) {
        Matcher matches = OPERAND_REGEX.matcher(operand);

        if (!matches.find()) {
            throw new IllegalArgumentException("유효한 피연산자 형식이 아닙니다.");
        }

        operandList.add(Integer.parseInt(operand));
    }

    public void isOperator(String operator) {
        Matcher matches = OPERATOR_REGEX.matcher(operator);

        if (!matches.find()) {
            throw new IllegalArgumentException("유효한 연산자 형식이 아닙니다.");
        }

        operatorList.add(operator);
    }

    public int calculateExpression() {

        int result = operandList.get(0);

        for (int i = 0; i < operatorList.size(); i++) {
            String operator = operatorList.get(i);
            int operand = operandList.get(i+1);
            result = Operator.operation(operator, result, operand);
        }

        return result;

    }

    public int execute(String expression) {
        StringUtil.checkBlank(expression);
        checkValidity(StringUtil.split(expression));

        return calculateExpression();
    }

}
