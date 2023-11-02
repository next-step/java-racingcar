package calculator;

public class StringAddCalculator {
    public int splitAndSum(String inputText) {
        Operands operands = new Operands(inputText);
        return Calculator.sum(operands);
    }
}
