package calculator;

import java.util.List;

public class Calculator {

    public static double calculate(String expression) {
        List<String> operands = OperationVerifier.verifyExpression(expression);
        return calculate(operands);
    }

    private static double calculate(List<String> operands) {
        double result = OperationVerifier.verifyOperand(operands.get(0));
        for(int i = 0; i < operands.size() - 2; i+= 2) {
            Operation operation = Operation.findBySymbol(operands.get(i+1));
            result = operation.execute(result, OperationVerifier.verifyOperand(operands.get(i+2)));
        }
        return result;
    }

}
