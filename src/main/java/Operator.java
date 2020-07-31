import org.graalvm.compiler.nodes.calc.IntegerDivRemNode;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public enum Operator implements Operatable {
    ADD("+") {
        @Override
        public int operate(int a, int b) {
            return a + b;
        }
    },
    SUBTRACT("-") {
        @Override
        public int operate(int a, int b) {
            return a - b;
        }
    },
    DIVIDE("/") {
        @Override
        public int operate(int a, int b) {
            return a / b;
        }
    },
    MULTIPLY("*") {
        @Override
        public int operate(int a, int b) {
            return a * b;
        }
    };

    private final String operator;
    private static final Map<String, Operator> operators;

    static {
        operators = Arrays.stream(values()).collect(Collectors.toMap(element -> element.operator, element -> element));
    }

    private Operator(String operator) {
        this.operator = operator;
    }

    public static Operator getOperator(String operator) {
        return operators.get(operator);
    }
}
