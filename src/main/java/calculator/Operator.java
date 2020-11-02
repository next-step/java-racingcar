package calculator;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public enum Operator {

    PLUS("+", (n1,n2) -> (n1 + n2)),
    MINUS("-", (n1,n2) -> (n1 - n2)),
    TIMES("*", (n1,n2) -> (n1 * n2)),
    DIVIDE("/", (n1,n2) -> (n1 / n2));

    private final String name;
    private final BiFunction<Integer,Integer,Integer> biFunction;

    private static class Types {
        static Map<String, Operator> operators = new HashMap<>();
    }

    Operator(String name, BiFunction<Integer, Integer, Integer> biFunction) {
        this.name = name;
        this.biFunction = biFunction;
        Types.operators.put(name,this);
    }

    public int calculate(int n1, int n2, String operator) {
        if(validationCheck(operator).name.equals("DIVIDE") && n2 <= 0) {
            throw new ArithmeticException(CalculatorError.E001);
        }
        return this.biFunction.apply(n1, n2);
    }

    public static Operator validationCheck(String operator) {
        Operator operatorType = Operator.Types.operators.get(operator);
        if(operatorType == null) {
            throw new IllegalArgumentException(CalculatorError.E000);
        }
        return operatorType;
    }

}
