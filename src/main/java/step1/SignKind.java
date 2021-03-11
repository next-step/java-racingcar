package step1;

import java.util.Arrays;
import java.util.function.BiFunction;


public enum SignKind {

    PLUS("+", (x, y) -> x + y),
    MINUS("-", (x, y) -> x - y),
    MULTIPLY("*", (x, y) -> x * y),
    DIVIDE("/", (x, y) -> x / y);

    private BiFunction<Integer, Integer, Integer> expression;

    //기호
    private String sign;

    SignKind(String sign, BiFunction<Integer, Integer, Integer> expression) {
        this.sign = sign;
        this.expression = expression;
    }

    public Integer calculate(Integer x, Integer y) {
        return getSign(sign).expression.apply(x,y);
    }

    public static SignKind getSign(String sign){
        return Arrays.stream(values()).filter(o->o.sign.equals(sign)).findFirst().orElseThrow(()-> new IllegalArgumentException("올바른 문자열이 아닙니다."));
    }


}
