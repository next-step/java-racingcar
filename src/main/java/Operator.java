import java.util.Arrays;
import java.util.function.Function;

public enum Operator {
    PLUS("+", p -> p.getLeft() + p.getRight());

    private final String opChar;

    private Function<Pair<Integer>, Integer> operate;

    Operator(String opChar, Function<Pair<Integer>, java.lang.Integer> operate) {
        this.opChar = opChar;
        this.operate = operate;
    }

    public Integer operate(Pair<Integer> pair) {
        return this.operate.apply(pair);
    }

    public static Operator fromOpChar(String opChar) {
        return Arrays.stream(Operator.values())
                .filter(o -> o.opChar.equals(opChar))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("Wrong operator: " + opChar));
    }


    @Override
    public String toString() {
        return opChar;
    }
}