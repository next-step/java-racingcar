package calculator;

import java.util.List;

public class Calculator {



    public int calculate(final String inputData) {
        List<String> calculationMaterials = InputParser.getCalculationMaterial(inputData);
        return execute(calculationMaterials);
    }

    private int execute(List<String> calculationMaterials) {
        int firstOperand = Integer.parseInt(calculationMaterials.get(0));
        int calculateResult = 0;

        for (int i = 1; i < calculationMaterials.size(); i += 2) {
                Operation operator = Operator.valueOfOperator(calculationMaterials.get(i));
                calculateResult = operator.calculate(firstOperand, Integer.parseInt(calculationMaterials.get(i + 1)));
                firstOperand = calculateResult;
        }
        return calculateResult;
    }


}
