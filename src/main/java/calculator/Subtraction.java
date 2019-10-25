package calculator;

public class Subtraction implements Calculator {
    @Override
    public int calculator(int left, int right) {
        return left - right;
    }
}
