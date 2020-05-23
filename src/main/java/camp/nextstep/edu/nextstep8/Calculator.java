package camp.nextstep.edu.nextstep8;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Calculator {
    public static final List<String> SUPPORTED_OPERATOR = Collections.unmodifiableList(Arrays.asList("+", "-", "*", "/"));

    public static int calculation(String expression) {
        List<String> expressionList = Arrays.asList(expression.split(StringUtils.SPACE));

        if (!isValidExpression(expressionList) ) {
            throw new IllegalArgumentException("입력한 식이 올바르지 않습니다 : " + expression);
        }

        int value = 0;
        Integer result = null;
        String operation = StringUtils.EMPTY;
        boolean isExecuteOperation = false;

        for (String s : expressionList) {

            if (StringUtils.isNumeric(s)) {
                value = Integer.parseInt(s);
                isExecuteOperation = true;
            }

            if (null == result) {
                result = value;
                continue;
            }

            if (isSupportedOperation(s)) {
                operation = s;
                isExecuteOperation = false;
            }

            if (StringUtils.isNotEmpty(operation) && isExecuteOperation){
                result = CalculationOperatorType.getOperatorTypeByOperator(operation).operation(result, value);
                operation = StringUtils.EMPTY;
            }
        }

        return result;
    }

    public static boolean isValidExpression(List<String> expressionList) {
        long numericCount = expressionList.stream().filter(s->StringUtils.isNumeric(s)).count();
        long supportedOperationCount = expressionList.stream().filter(s->isSupportedOperation(s)).count();
        return numericCount == (supportedOperationCount + 1);
    }

    public static boolean isSupportedOperation(String operation){
        return SUPPORTED_OPERATOR.contains(operation);
    }
}