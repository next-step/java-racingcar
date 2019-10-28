package stringcalculator;

import stringcalculator.operation.OperatorGroup;
import stringcalculator.store.CalculatorBuffer;

import java.util.Queue;

public class StringCalculator {

    public static Double calculate(CalculatorBuffer calculatorBuffer) {
        Queue<Double> numbers = calculatorBuffer.getNumbers();
        Queue<String> operators = calculatorBuffer.getOperators();

        Double result = numbers.poll();
        while (!operators.isEmpty()) {
            OperatorGroup operator = OperatorGroup.findOperator(operators.poll());
            result = operator.operate(result, numbers.poll());
        }
        return result;
    }

}
