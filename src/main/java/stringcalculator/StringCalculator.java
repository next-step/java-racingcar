package stringcalculator;

import stringcalculator.operation.OperatorGroup;
import stringcalculator.store.CalculatorBuffer;

import java.util.Queue;

public class StringCalculator {

    public static Double calculate(CalculatorBuffer calculatorBuffer) {
        Queue<Double> numberCollection = calculatorBuffer.getNumberCollection();
        Queue<String> operatorCollection = calculatorBuffer.getOperatorCollection();

        Double result = numberCollection.poll();
        while (!operatorCollection.isEmpty()) {
            Double x = result;
            Double y = numberCollection.poll();
            String inputOperator = operatorCollection.poll();
            OperatorGroup operator = OperatorGroup.findOperator(inputOperator);
            result = operator.operate(x, y);
        }
        return result;
    }

}
