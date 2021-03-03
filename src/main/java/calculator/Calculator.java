package calculator;



import java.util.function.BiFunction;

public enum Calculator {
    PLUS((a,b) -> (a+b)),
    MINUS((a,b) -> (a-b)),
    MULTIPLE((a,b) -> (a*b)),
    DIVIDE((a,b) -> (a/b));

    private final BiFunction<Integer, Integer, Integer> biFunction;

    Calculator(BiFunction<Integer, Integer, Integer> binFunction) {
        this.biFunction = binFunction;
    }

    public int calculate(int a, int b) {
        return this.biFunction.apply(a,b);
    }
}
