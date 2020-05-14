package step2;

public class Calculator {


    public Double calculate(Double firstNumber, Double secondNumber, String symbol) {
        Operation operation = Operation.getOperation(symbol);
        return operation.calculate(firstNumber, secondNumber);
    }
}
