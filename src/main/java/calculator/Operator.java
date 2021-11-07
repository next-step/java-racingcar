package calculator;

import com.sun.tools.javac.util.Pair;

import java.util.Arrays;
import java.util.function.Function;

import static calculator.Calculator.*;

public enum Operator {
    PLUS(PLUS_SYMBOL, pair -> pair.fst.plus(pair.snd)),
    MINUS(MINUS_SYMBOL, pair -> pair.fst.minus(pair.snd)),
    MULTIPLE(MULTIPLE_SYMBOL, pair -> pair.fst.multiple(pair.snd)),
    DIVIDE(DIVIDE_SYMBOL, pair -> pair.fst.divideBy(pair.snd));

    private String operation;
    private Function<Pair<MyNumber, MyNumber>, MyNumber> expression;

    Operator(String operation, Function<Pair<MyNumber, MyNumber>, MyNumber> expression) {
        this.operation = operation;
        this.expression = expression;
    }

    public static Operator of(String symbol) {
        return Arrays.stream(Operator.values())
                .filter(operation -> operation.hasOperation(symbol))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("사칙 연산 기호가 아닙니다."));
    }

    public boolean hasOperation(String symbol) {
        return operation.equals(symbol);
    }

    public MyNumber calculate(MyNumber first, MyNumber second) {
        return expression.apply(new Pair(first, second));
    }
}
