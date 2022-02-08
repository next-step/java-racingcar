package calculator.domain;

import calculator.util.StringUtils;
import java.util.ArrayList;
import java.util.List;
import calculator.domain.StringParsing;

public class Calculator {

    private List<Operand> operandList;
    private List<Operation> operationList;

    public Calculator() {
        operandList = new ArrayList<>();
        operationList = new ArrayList<>();
    }

    public int calculate(String expression) {
        String[] splitExpression = StringUtils.splitExpression(expression);
        StringParsing stringParsing = new StringParsing(splitExpression);
        operandList = stringParsing.getOperandList();
        operationList = stringParsing.getOperationList();
        calculateExpression();
        return calculateExpression();
    }

    private int calculateExpression() {
        int calculateResult = 0;
        Operand left = operandList.get(0);
        for (int index = 0; index < operationList.size(); index++) {
            Operation operation = operationList.get(index);
            Operand right = operandList.get(index + 1);
            calculateResult = operation.operate(left, right);
        }
        return calculateResult;
    }
}
