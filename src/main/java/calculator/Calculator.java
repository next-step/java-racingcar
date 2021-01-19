package calculator;

import java.util.ArrayList;
import java.util.Arrays;

public class Calculator {

    private final String formula;
    private ArrayList<String> operators;
    private ArrayList<String> operands;
    private ArrayList<Double> doubleOperands;

    public Calculator(String formula) {
        this.formula = formula;
    }

    private void splitFormula() {
        String eq = formula.replaceAll(" ", "");
        operators = new ArrayList<>(Arrays.asList(eq.split("[0-9]+")));
        operands = new ArrayList<>(Arrays.asList(eq.split("[-+*/()]")));

        // FIXME: 값을 내는 별도의 메소드 필요
        validateFormula();
        sanitizeOperator(operators);
        doubleOperands = stringToDouble(operands);
        System.out.println(calculateFormula(operators, doubleOperands));
    }

    public static ArrayList<Double> stringToDouble(ArrayList<String> array) {
        ArrayList<Double> result = new ArrayList<>(array.size());
        for (int i = 0; i < array.size(); i++) {
            result.add(i, Double.parseDouble(array.get(i)));
        }
        return result;
    }

    /**
     * Calculate mathematics equation.
     * @param operators, The list of double.
     * @param operands The list of String (+, -, *, /).
     * @return result Double, calculated result
     */
    public static double calculateFormula(ArrayList<String> operators, ArrayList<Double> operands) {
        // TODO: 색다른 방법 있으면 알아보기!
        double result = operands.get(0);
        int j = 0;
        for (int i = 1; i < operands.size(); i++) {
            result = Arithmetic.calculate(operators.get(j), result, operands.get(i));
            j++;
        }
        System.out.println(result);
        return result;
    }

    private void validateFormula() {
        validateOperand(operands);
        validateOperator(operators, operands);
    }

    private void validateOperand(ArrayList<String> operands) {
        for(String operand:operands) {
            System.out.println(">>" + operand);
            boolean isDigit = operand.chars().allMatch( Character::isDigit );
            if (!isDigit) {
                throw new IllegalArgumentException("잘못된 피연산자입니다.");
            }
        }
    }

    private void validateOperator(ArrayList<String> operators, ArrayList<String> operands) {
        sanitizeOperator(operands);
        if (operators.size() == operands.size() + 1) {
            throw new IllegalArgumentException("잘못된 연산자입니다.");
        }
    }

    private void sanitizeOperator(ArrayList<String> operators) {
        operators.remove("");
    }
}