package study02;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public enum Operator {
    PLUS("+", (first, second) -> new Operand(first.getValue() + second.getValue())),
    MINUS("-", (first, second) -> new Operand(first.getValue() - second.getValue())),
    TIMES("*", (first, second) -> new Operand(first.getValue() * second.getValue())),
    DIVIDE("/", (first, second) -> {
        if (second.getValue() == 0) {
            throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
        }
        return new Operand(first.getValue() / second.getValue());
    });

    private final String operator;
    private final BiFunction<Operand, Operand, Operand> calculate;

    Operator(String operator, BiFunction<Operand, Operand, Operand> calculate) {
        this.operator = operator;
        this.calculate = calculate;
    }

    public Operand calculate(Operand first, Operand second) {
        return calculate.apply(first, second);
    }

    public static Operator of(String operator) {
        return Arrays.stream(values())
                .filter(it -> operator.equals(it.operator))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("올바른 연산자가 아닙니다."));
    }

    public static boolean valid(String operator) {
        try {
            Operator.of(operator);
        } catch (IllegalArgumentException e) {
            return false;
        }
        return true;
    }

    public static List<Operator> parse(String[] formula) {
        List<Operator> operatorList = Arrays.stream(formula)
                .filter(Operator::valid)
                .map(Operator::of)
                .collect(Collectors.toList());

        Collections.reverse(operatorList);

        return operatorList;
    }


    @Override
    public String toString() {
        return this.operator;
    }
}
