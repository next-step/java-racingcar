package calculator;

public class Operator {

    private double add(double number1, double number2) {
        return number1 + number2;
    }

    private double subtract(double number1, double number2) {
        return number1 - number2;
    }

    private double multiple(double number1, double number2) {
        return number1 * number2;
    }

    private double divide(double number1, double number2) {
        int DIGIT_RANGE = 2;
        if (number2 == 0) {
            throw new IllegalArgumentException("[ERROR] 0으로 나눌 수 없습니다.");
        }
        return Math.round((number1 / number2) * Math.pow(10, DIGIT_RANGE)) / Math.pow(10,
            DIGIT_RANGE);
    }

}
