package calcurator;

import java.util.Arrays;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum Calculator {
    ADD("+", (a, b) -> a + b),
    SUBTRACT("-", (a, b) -> a - b),
    MULTIPLY("*", (a, b) -> a * b),
    DIVISION("/", (a, b) -> a / b);


    private static final Map<String, Calculator> operationMap = Arrays.stream(values()).collect(
            Collectors.toMap(x -> x.operation, Function.identity(),  (calculator, calculator2) -> calculator));
    private String operation;
    private BiFunction<Integer, Integer, Integer> calculate;

    Calculator(String operation, BiFunction<Integer, Integer, Integer> calculate) {
        this.operation = operation;
        this.calculate = calculate;

    }

    public String getOperation() {
        return this.operation;
    }

    public BiFunction<Integer, Integer, Integer> getCalculate() {
        return this.calculate;
    }

    public static Calculator calculateByOperation(String operation) {
        Calculator finedOperation = operationMap.get(operation);

        if (finedOperation == null) {
            throw new IllegalArgumentException();
        }

        return finedOperation;
    }
}
