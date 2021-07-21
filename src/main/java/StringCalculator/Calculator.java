package StringCalculator;

import StringCalculator.Enum.Operation;

public class Calculator {

    private Calculator() {
    }

    public static int calculate(String expression) {
        String[] terms = expression.split(" ");
        Operation operation;
        int leftTerm = Numeric.of(terms[0]).getData();
        int rightTerm;
        for (int i = 1; i < terms.length; i += 2) {
            operation = Operation.find(terms[i]);
            rightTerm = Numeric.of(terms[i + 1]).getData();
            leftTerm = operation.apply(leftTerm, rightTerm);
        }

        return leftTerm;
    }

}
