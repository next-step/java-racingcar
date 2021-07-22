package calc;

import calc.type.Operation;

public class Calculation {
    public int calc(String formula) {
        String[] formulaArr = formula.split(" ");
        if (formula == null || formula.trim().equals("") || formulaArr.length == 0) {
            throw new IllegalArgumentException("formula is blank");
        }

        int result = Integer.parseInt(formulaArr[0]);
        int i = 1;
        while (i < formulaArr.length) {
            String operation = formulaArr[i++];
            int num = Integer.parseInt(formulaArr[i++]);
            result = calculate(result, num, operation);
        }
        System.out.println("result : "+ result);
        return result;
    }

    public int calculate(int operand1, int operand2, String operation) {
        return Operation.findByOperation(operation).calc(operand1, operand2);
    }

}
