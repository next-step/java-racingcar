import java.util.function.BiFunction;

/**
 * ExpressionPart : 연산자
 */
public enum Operator implements ExpressionPart {
    Plus("+", (value1, value2) -> value1 + value2),
    Minus("-", (value1, value2) -> value1 - value2),
    Multiple("*", (value1, value2) -> value1 * value2),
    Divide("/", (value1, value2) -> value1 / value2);

    private String sign;

    private BiFunction<Integer, Integer, Integer> executor;

    Operator(String sign, BiFunction<Integer, Integer, Integer> executor) {
        this.sign = sign;
        this.executor = executor;
    }

    public static Operator valueOfSign(String sign) {
        Operator[] ops = Operator.values();
        for (int i = 0; i < ops.length; i++) {
            if (ops[i].sign.equals(sign)) return ops[i];
        }
        throw new EnumConstantNotPresentException(Operator.class, sign);
    }

    public Integer execute(Integer value1, Integer value2) {
        return executor.apply(value1, value2);
    }

    @Override
    public Type type() {
        return Type.Operator;
    }
}
