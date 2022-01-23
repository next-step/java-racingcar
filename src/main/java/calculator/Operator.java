package calculator;

public class Operator {

    public double add(double number1, double number2) {
        return number1 + number2;
    }

    public double subtract(double number1, double number2) {
        return number1 - number2;
    }

    public double multiple(double number1, double number2) {
        return number1 * number2;
    }

    public double divide(double number1, double number2) {
        int DIGIT_RANGE = 2;
        if (number2 == 0) {
            throw new IllegalArgumentException("[ERROR] 0으로 나눌 수 없습니다.");
        }
        return Math.round((number1 / number2) * Math.pow(10, DIGIT_RANGE)) / Math.pow(10,
            DIGIT_RANGE);
    }

}
