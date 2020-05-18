package study.step2_1;

import java.util.List;
import java.util.Objects;

public class Calculation implements Calculator{
    private static final int INIT_INDEX = 0;
    private static final int NEXT_NUMBER_INDEX = 1;

    private final static int NUMBER_ONE = 1;
    private final static int NUMBER_TWO = 2;

    private List<Double> numbers;
    private List<String> operators;
    private String [] inputValues;

    public Calculation(String [] inputValues, List<Double> separateNumber, List<String> separateOperator) {
        this.inputValues = inputValues;
        this.numbers = validateNumbers(separateNumber);
        this.operators = validateOperator(separateOperator);
    }

    private List<String> validateOperator(List<String> separateOperator) {
        if (isNaturalOperator(separateOperator)){
            return separateOperator;
        }
        throw new IllegalArgumentException();
    }

    private List<Double> validateNumbers(List<Double> numbers) {
        if (isNaturalNumber(numbers)){
            return numbers;
        }
        throw new IllegalArgumentException();
    }

    private boolean isNaturalOperator(List<String> separateOperator) {
        return !Objects.isNull(separateOperator) && (inputValues.length - NUMBER_ONE) / NUMBER_TWO == separateOperator.size();
    }

    private boolean isNaturalNumber(List<Double> numbers) {
        return !Objects.isNull(numbers) && (inputValues.length + NUMBER_ONE) / NUMBER_TWO == numbers.size();
    }

    public double calculate() {
        double result = numbers.get(INIT_INDEX);
        int size = operators.size() - 1;

        for (int i = INIT_INDEX; i <= size; i++){
            result = Operator.findOperator(operators.get(i)).calculate(result, numbers.get(NEXT_NUMBER_INDEX));
            numbers.removeIf(value -> isConsumeNumbers(value));
            numbers.set(INIT_INDEX,result);
        }

        return result;
    }

    private boolean isConsumeNumbers(Double value) {
        return value == numbers.get(INIT_INDEX);
    }

}
