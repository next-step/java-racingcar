package step2;

public class Calculator {

    public Double calculate(String equation) {
        String[] elements = equation.split(" ");
        Double firstArgument = parseDouble(elements[0]);
        for (int i = 1; i < elements.length; i++) {
            Operation operation = Operation.getOperation(elements[i++]);
            Double secondArgument = parseDouble(elements[i]);
            firstArgument = operation.calculate(firstArgument, secondArgument);
        }
        return firstArgument;
    }

    private double parseDouble(String number) {
        return Double.parseDouble(number);
    }


}
