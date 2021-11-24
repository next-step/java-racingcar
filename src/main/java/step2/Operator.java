package step2;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public enum Operator {
    ADD("+", list -> sum(list)),
    SUB("-", list -> sub(list)),
    MUL("*", list -> mul(list)),
    DIV("/", list -> div(list));

    private static final int INDEX_OF_VALUE = 1;
    private static final int INDEX_OF_RESULT = 0;
    private static final String IAE_MESSAGE = "사칙연산 기호를 확인해주세요 :(";

    private String operation;
    private Function<List<Integer>, Integer> expression;

    Operator(String operation, Function<List<Integer>, Integer> expression) {
        this.operation = operation;
        this.expression = expression;
    }

    public static Operator getOperatorByCode(String operation) {
        return Arrays.stream(Operator.values())
                .filter(operator -> operator.operation.equals(operation))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(IAE_MESSAGE));
    }

    public int calculate(List<Integer> list) {
        return expression.apply(list);
    }

    private static int sum(List<Integer> list) {
        return list.get(INDEX_OF_RESULT) + list.get(INDEX_OF_VALUE);
    }

    private static int sub(List<Integer> list) {
        return list.get(INDEX_OF_RESULT) - list.get(INDEX_OF_VALUE);
    }

    private static int mul(List<Integer> list) {
        return list.get(INDEX_OF_RESULT) * list.get(INDEX_OF_VALUE);
    }

    private static int div(List<Integer> list) {
        return list.get(INDEX_OF_RESULT) / list.get(INDEX_OF_VALUE);
    }

}
