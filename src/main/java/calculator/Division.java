package calculator;

public class Division implements Calculator {
    @Override
    public int calculator(int left, int right) {
        return left / right;
    }
}
