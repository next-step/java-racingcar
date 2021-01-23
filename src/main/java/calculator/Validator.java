package calculator;

import java.util.ArrayList;

public class Validator {

    public static void validateFormula(ArrayList<String> operands, ArrayList<String> operators) {
        validateOperand(operands);
        validateOperator(operators, operands);
    }

    private static void validateOperand(ArrayList<String> operands) {
        for(String operand : operands) {
            boolean isDigit = operand.chars().allMatch( Character::isDigit );
            if (!isDigit) {
                throw new IllegalArgumentException("잘못된 식입니다.");
            }
        }
    }

    private static void validateOperator(ArrayList<String> operators, ArrayList<String> operands) {
        if (operators.size() == operands.size() + 1) {
            throw new IllegalArgumentException("잘못된 식입니다.");
        }
    }
}