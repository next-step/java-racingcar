package calculator;

public class Plus implements Calculator {
    @Override
    public int calc(int a, int b) {
        return a + b;
    }
}
