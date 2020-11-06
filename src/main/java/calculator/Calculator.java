package calculator;

import utils.StringUtil;

import java.util.Arrays;

public class Calculator {
    public final static String INPUT_EXCEPTION_MSG="입력된 값에 오류가 있습니다.";

    private String getValidExpression(String in) throws IllegalArgumentException{
        if(in == null || in.isEmpty() || in.replace(StringUtil.WHITESPACE,"").length() == 0){
            throw new IllegalArgumentException(INPUT_EXCEPTION_MSG);
        }
        return in;
    }

    public long getResult(String expression){
        String validExpression = getValidExpression(expression);

        long[] operands = getOperands(validExpression);
        Operator[] operators = getOperators(validExpression);

        long acc = operands[0];

        for(int i = 1; i < operands.length; i++){
            acc = operators[i-1].action(acc, operands[i]);
        }

        return acc;
    }

    private long[] getOperands(String expression){
        return Arrays.stream(StringUtil.regexSplit(expression, StringUtil.REGEX_OPERATOR))
                .filter(x->!x.isEmpty())
                .mapToLong(x->Long.valueOf(x.trim()))
                .toArray();
    }

    private Operator[] getOperators(String expression){
        return Arrays.stream(StringUtil.regexSplit(expression, StringUtil.REGEX_OPERAND))
                .map(String::trim)
                .filter(x->!x.isEmpty())
                .map(Operator::getOperator)
                .toArray(Operator[]::new);
    }

}
