package calculator;

import calculator.operator.OperatorEnum;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    private final static String FORMULA_SEPARATION_KEYWROD = " ";

    private List<Double> numbers;
    private List<OperatorEnum> operators;

    public Calculator(String input) {
        this.numbers = new ArrayList<>();
        this.operators = new ArrayList<>();
        validateEmpty(input);
        separateFormula(input);
    }

    public Double calculate() {
        double result = this.numbers.get(0);

        for (int i = 0; i < operators.size(); i++) {
            result = operators.get(i).calculate(result, this.numbers.get(i + 1));
        }
        return result;
    }

    private void separateFormula(String input) {
        String[] splitInput = input.split(FORMULA_SEPARATION_KEYWROD);

        for (int i = 0; i < splitInput.length; i++) {
            if (i % 2 == 0) {
                this.numbers.add(getNumberFromFormula(splitInput[i]));
                continue;
            }
            this.operators.add(getOperatorFromFormula(splitInput[i]));
        }
    }

    private OperatorEnum getOperatorFromFormula(String inputWord) {
        return OperatorEnum.getOperatorEnumFromKeyword(inputWord);
    }

    private double getNumberFromFormula(String inputWord) {
        double number;
        try {
            number = Double.parseDouble(inputWord);
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException("수식 중 숫자가 잘못되었습니다.");
        }
        return number;
    }

    private void validateEmpty(String input) {
        if (input == null || "".equals(input.trim())) {
            throw new IllegalArgumentException("수식이 비워져 있습니다.");
        }
    }
}
