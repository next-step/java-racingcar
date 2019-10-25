package calculator;

public class Multiplication implements Calculator {
    @Override
    public int calculator(int left, int right) {
        return left * right;
    }
}
