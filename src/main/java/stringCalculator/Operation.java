package stringCalculator;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.BiFunction;

public enum Operation {
    ADDING("+", (number1, number2) -> number1 + number2),
    SUBTRACTION("-", (number1, number2) -> number1 - number2),
    MULTIPLICATION("*", (number1, number2) -> number1 * number2),
    DIVISION("/", (number1, number2) -> number1 / number2);

    private String opterator;

    private BiFunction<Integer, Integer, Integer> fomular;

    Operation(String opterator, BiFunction<Integer, Integer, Integer> fomular) {
        this.opterator = opterator;
        this.fomular = fomular;
    }


    public static Operation getOperation(String opterator) {
        Optional<Operation> operation = Arrays.stream(Operation.values()).filter(obj -> obj.opterator.equals(opterator)).findAny();
        if (!operation.isPresent()) {
            throw new IllegalArgumentException("calculating param is wrong : contained not number or wrong opterator");
        }
        return operation.get();
    }


    public int operate(int number1, int number2) {
        return fomular.apply(number1, number2);
    }

}
