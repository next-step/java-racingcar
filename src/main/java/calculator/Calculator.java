package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Calculator {
    private List<String> operators;
    private List<String> operands;

    public double getAnswer(String formula) {
        splitFormula(formula);
        validateFormula();
        sanitizeOperator(operators);
        List<Double> doubleOperands = stringToDouble(operands);
        return calculateFormula(operators, doubleOperands);
    }

    private void splitFormula(String formula) {
        String equation = formula.replaceAll(" ", "");
        operators = Arrays.asList(equation.split("[0-9]+"));
        operands = Arrays.asList(equation.split("[-+*/()]"));
    }

    private void validateFormula() {
        validateOperand(operands);
        validateOperator(operators, operands);
    }

    private List<Double> stringToDouble(List<String> array) {
        List<Double> result = new ArrayList<>(array.size());
        for (int i = 0; i < array.size(); i++) {
            result.add(i, Double.parseDouble(array.get(i)));
        }
        return result;
    }

    private void validateOperand(List<String> operands) {
        for(String operand:operands) {
            System.out.println(">>" + operand);
            boolean isDigit = operand.chars().allMatch( Character::isDigit );
            if (!isDigit) {
                throw new IllegalArgumentException("잘못된 식입니다.");
            }
        }
    }

    private void validateOperator(List<String> operators, List<String> operands) {
        sanitizeOperator(operands);
        if (operators.size() == operands.size() + 1) {
            throw new IllegalArgumentException("잘못된 식입니다.");
        }
    }

    private void sanitizeOperator(List<String> operators) {
        operators.remove("");
    }

    /**
     * Calculate mathematics equation.
     * @param operators, The list of double.
     * @param operands The list of String (+, -, *, /).
     * @return result Double, calculated result
     */
    private double calculateFormula(List<String> operators, List<Double> operands) {
        double result = operands.get(0);
        int j = 0;
        for (int i = 1; i < operands.size(); i++) {
            result = Arithmetic.calculate(operators.get(j), result, operands.get(i));
            j++;
        }
        return result;
    }
}