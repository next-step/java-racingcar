package calculate;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class CalculateEnum {
    enum Operator {
        PLUS("+", (num1, num2) -> num1 + num2),
        MINUS("-", (num1, num2) -> num1 - num2),
        MULTIPLY("*", (num1, num2) -> num1 * num2),
        DIVIDE("/", (num1, num2) -> num1 / num2);

        private String operator;
        private BiFunction<Double, Double, Double> expression;

        Operator(String operator, BiFunction<Double, Double, Double> expression) {
            this.operator = operator;
            this.expression = expression;
        }

        public double calculate(double num1, double num2) {
            return this.expression.apply(num1, num2);
        }
    }

    private static Map<String, Operator> operators = new HashMap<>();

    static {
        for (Operator value : Operator.values())
            operators.put(value.operator, value);
    }

    public static double calculate(String operator, double num1, double num2) {
        return operators.get(operator).calculate(num1, num2);
    }

}


class MyTest {


    @Test
    void EnumTest() {
        double a = 1, b = 2;
        String method = "*";
        double result = CalculateEnum.calculate("+", a, b);
//        System.out.println(CalculateEnum.Operator.values().toString());
//        for (CalculateEnum.Operator aa : CalculateEnum.Operator.values()) {
//            System.out.println(aa.toString());
//        }
    }
}
