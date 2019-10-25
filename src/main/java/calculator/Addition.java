package calculator;

public class Addition implements Calculator {

    @Override
    public int calculator(int left, int right) {
        return left + right;
    }
}
