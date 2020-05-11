package StringCalculator;

public class ArithmeticExpression {

    private String arithmeticExpression;

    public ArithmeticExpression(String arithmeticExpression) {
        this.arithmeticExpression = arithmeticExpression;
    }

    @Override
    public String toString() {
        return arithmeticExpression.toString();
    }


}
