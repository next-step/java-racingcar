package step2;

import java.util.Arrays;
import java.util.Objects;

public class Calculator {

    public Double calculate(String equation) {
        String[] elements = validateEquation(equation);

        Double firstArgument = parseDouble(elements[0]);
        for (int i = 1; i < elements.length; i++) {
            Operation operation = Operation.getOperation(elements[i++]);
            Double secondArgument = parseDouble(elements[i]);
            firstArgument = operation.calculate(firstArgument, secondArgument);
        }
        return firstArgument;
    }

    private double parseDouble(String number) {
        // TODO : Exception Handling
        return Double.parseDouble(number);
    }

    public String[] validateEquation(String equation){
        if(isNull(equation)) throw new IllegalArgumentException("Null 값은 올 수 없습니다");
        if(isEmpty(equation)) throw new IllegalArgumentException("Empty 값은 올 수 없습니다");
        if(!isValidate(equation)) throw new IllegalArgumentException("올바른 계산식이 아닙니다");
        return equation.split(" ");
    }

    private boolean isValidate(String equation) {
        return equation.length() % 2 != 0 || equation.split(" ").length > 3;
    }

    private boolean isEmpty(String equation) {
        return equation.isEmpty();
    }

    private boolean isNull(String equation) {
        return Objects.isNull(equation);
    }


}
