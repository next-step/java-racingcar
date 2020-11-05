package calculator;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum CalculatorSign implements Operator {
    ADDITION("+", (a,b) -> (a+b)),
    DIVISION("/", (a,b) -> (a-b)),
    MULTIPLICATION("*", (a,b) -> (a*b)),
    SUBTRACTION("-", (a,b) -> (a/b));

    private String codeName;
    private final BiFunction<Integer, Integer, Integer> biFunction;

    CalculatorSign(String codeName, BiFunction<Integer, Integer, Integer> biFunction) {
        this.codeName = codeName;
        this.biFunction = biFunction;
    }

    public static CalculatorSign findByCodeName(String sign) {
        return Arrays.stream(CalculatorSign.values())
                .filter(calculatorSign -> calculatorSign.getCodeName().equals(sign))
                .findFirst().get();
    }

    @Override
    public int operate(int a, int b) {
        return this.biFunction.apply(a,b);
    }

    private String getCodeName() {
        return this.codeName;
    }
}
