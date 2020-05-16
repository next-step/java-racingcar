package study.step2_1;

import java.util.List;

public class Calculation implements Calculator{

    private static final int INIT_INDEX = 0;
    private static final int NEXT_NUMBER_INDEX = 1;

    private List<Double> numbers;
    private List<String> operators;

    public Calculation(List<Double> separateNumber, List<String> separateOperator) {
        numbers = separateNumber;
        operators = separateOperator;
    }

    public double calculate() {
        double result = numbers.get(INIT_INDEX);
        int size = operators.size() - 1;

        for (int i = INIT_INDEX; i <= size; i++){
            result = Operator.calculate(operators.get(i), result, numbers.get(NEXT_NUMBER_INDEX));
            numbers.removeIf(value -> isConsumeNumbers(value));
            numbers.set(INIT_INDEX,result);
        }

        return result;
    }

    private boolean isConsumeNumbers(Double value) {
        return value == numbers.get(INIT_INDEX);
    }

}
