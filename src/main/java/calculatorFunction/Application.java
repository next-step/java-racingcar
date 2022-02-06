package calculatorFunction;

import java.util.ArrayList;

public class Application {

    public static void main(String[] args) {
        System.out.println("수식을 입력하시오: ");
        String expression = GetInput.inputString();
        if (expression.length() == 0) {
            throw new IllegalArgumentException("Error: need right expression");
        }
        ArrayList<String> parsedValues = GetInput.parse(expression);
        Calculator calculator = new Calculator(parsedValues);
        calculator.returnCalculatedValue();
    }
}
