package calculator;

import java.util.ArrayList;
import java.util.Arrays;

public class Calculator {

    private final String formula;
//    private String[] operators;
//    private String[] operands;
    private ArrayList<String> operators;
    private ArrayList<String> operands;

    public Calculator(String formula) {
        this.formula = formula;
    }

    private void splitFormula(String formula) {
        String eq = "2".replaceAll(" ", "");
        operators = new ArrayList<>(Arrays.asList(eq.split("[0-9]+")));
        operands = new ArrayList<>(Arrays.asList(eq.split("[-+*/()]")));

        // TODO! String -> Double
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

    private void validateFormula(String formula) {
        // 피연산자 검사
        validateOperand(operators);

        // 연산자 검사
        validateOperator(operators, operands);
    }

    private void validateOperand(ArrayList<String> operators) {
        for(String operator:operators) {
            boolean isDigit = operator.chars().allMatch( Character::isDigit );
            if (isDigit) {
                throw new IllegalArgumentException("잘못된 피연산자입니다.");
            }
        }
    }

    private void validateOperator(ArrayList<String> operators, ArrayList<String> operands) {
        sanitizeOperator(operands);

        // 연산자의 수 = 숫자 의 수 - 1
        if (operators.size() == operands.size() - 1) {

        }
    }

    private void sanitizeOperator(ArrayList<String> operands) {
        operators.remove("");
    }
}

// 2 +  @3 * 4 / 2
// [, +@, *, /]
// [2, @3, 4, 2]