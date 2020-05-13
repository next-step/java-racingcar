package study.step2_1;

import java.util.List;

public class Calculation {
    private static List<Double> numbers;
    private static List<String> operators;

    private static final int INIT_INDEX = 0;
    private static final int INCREASE_INDEX = 1;

    public Calculation(List<Double> separateNumber, List<String> separateOperator) {
        numbers = separateNumber;
        operators = separateOperator;
    }

    public double calculate() {
        double result = numbers.get(INIT_INDEX);
        int size = operators.size()-1;

        for (int i = INIT_INDEX; i <= size; i++){
            result = Operator.calculate(operators.get(i), result, numbers.get(INCREASE_INDEX));
            numbers.removeIf(Calculation::isConsumeNumbers);
            numbers.set(INIT_INDEX,result);
        }

        return result;
    }

    private static boolean isConsumeNumbers(Double value) {
        if (value == numbers.get(INIT_INDEX) ){
            return true;
        }
        return false;
    }

}
