package step2;
import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {
	
    PLUS("+", (leftOperand, rightOperand) -> leftOperand + rightOperand),
    MINUS("-", (leftOperand, rightOperand) -> leftOperand - rightOperand),
    MULTIPLY("*", (leftOperand, rightOperand) -> leftOperand * rightOperand),
    DIVIDE("/", (leftOperand, rightOperand) -> {
    	if(rightOperand == 0) {
    		throw new IllegalArgumentException("0으로 나누는 것은 불가능합니다.");
    	}
    	return leftOperand / rightOperand;
    });

    private String operator;
    private BiFunction<Integer, Integer, Integer> expression;

    Operator(String operator, BiFunction<Integer, Integer, Integer> expression) {
        this.operator = operator;
        this.expression = expression;
    }

    public static int calculate(String operator, int leftOperand, int rightOperand) {
        return getOperator(operator).expression.apply(leftOperand, rightOperand);
    }
    
    private static Operator getOperator(String operator) {
        return Arrays.stream(values())
                .filter(o -> o.operator.equals(operator))
                .findFirst().orElseThrow(() -> new IllegalArgumentException("사용 불가능한 연산자입니다."));
    }
}
