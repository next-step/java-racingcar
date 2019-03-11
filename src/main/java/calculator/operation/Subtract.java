package calculator.operation;

public class Subtract implements Operation {

    @Override
    public int calculate(int a, int b) {
        return a - b;
    }
}
