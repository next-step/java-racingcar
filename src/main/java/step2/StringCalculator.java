package step2;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.stream.IntStream;

class StringCalculator {

    private enum OperatorType {

        ADD("+", (x, y) -> x + y),
        SUBSTRACT("-", (x, y) -> x - y),
        MULTIPL("*", (x, y) -> x * y),
        DIVIDE("/", (x, y) -> {
            try {
                return x / y;
            } catch (ArithmeticException e) {
                throw new IllegalArgumentException();
            }
        });

        private final String operator;
        private final BiFunction<Integer, Integer, Integer> operation;

        OperatorType(String operator, BiFunction<Integer, Integer, Integer> operation) {
            this.operator = operator;
            this.operation = operation;
        }

        static private boolean validateOperator(String operator) {
            return Arrays
                    .stream(values())
                    .map(OperatorType::getOperator)
                    .anyMatch(operator::equals);
        }

        static private int operate(String operator, int x, int y) {
            return Arrays
                    .stream(values())
                    .filter(operatorType -> operatorType.getOperator().equals(operator))
                    .mapToInt(filtered -> filtered.getOperation().apply(x, y))
                    .max()
                    .orElse(0);
        }

        private String getOperator() {
            return operator;
        }

        private BiFunction<Integer, Integer, Integer> getOperation() {
            return operation;
        }
    }

    private String[] splitInput(String input) throws IllegalArgumentException {
        if (input == null) {
            throw new IllegalArgumentException();
        }

        return input.split(" ");
    }

    private void validateInputs(String[] inputs) throws IllegalArgumentException {
        if (inputs.length % 2 == 0) {
            throw new IllegalArgumentException();
        }
        IntStream
                .range(0, inputs.length)
                .forEach(index -> validate(inputs[index], index));
    }

    private void validate(String string, int index) throws IllegalArgumentException {
        if (
                ("".equals(string))
                        || (index % 2 == 0 && !validateStringToInteger(string))
                        || (index % 2 != 0 && !OperatorType.validateOperator(string))
        ) {
            throw new IllegalArgumentException();
        }
    }

    private boolean validateStringToInteger(String string) {
        try {
            Integer.parseInt(string);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    int calculateString(String input) throws IllegalArgumentException {
        String[] inputs = splitInput(input);
        validateInputs(inputs);

        return IntStream
                .range(0, inputs.length / 2)
                .reduce(Integer.parseInt(inputs[0]), (accumulator, index) -> {
                    int converted = index * 2 + 1;
                    String operater = inputs[converted];
                    int operand = Integer.parseInt(inputs[converted + 1]);
                    return OperatorType.operate(operater, accumulator, operand);
                });
    }
}
