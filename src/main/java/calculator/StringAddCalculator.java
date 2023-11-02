package calculator;

public class StringAddCalculator {
    public int splitAndSum(String inputText) {
        Operands operands = new Operands(inputText);
        Calculator calculator = new Calculator();
        return calculator.sum(operands);
    }
}
