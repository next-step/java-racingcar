import java.util.function.IntBinaryOperator;

public class StringCalculator {
    public int calculate(String params) {
        if (params == null || params.length() == 0) {
            throw new IllegalArgumentException("Unvalid parameter");
        }
        String[] strings = params.split(" ");
        int result = Integer.parseInt(strings[0]);
        int index = 1;
        IntBinaryOperator binaryOperator = null;
        while (index < strings.length) {
            if ("+-*/".contains(strings[index])) {
                binaryOperator = getOperator(strings[index]);
                result = binaryOperator.applyAsInt(result, Integer.parseInt(strings[index+1]));
                index += 1;
            }
            int i = Integer.parseInt(strings[index]);
            System.out.println(i);
            index++;
        }
        return result;
    }

    public IntBinaryOperator getOperator(String operatorString) {
        if (operatorString.equals("+")) {
            IntBinaryOperator add = (left, right) -> left + right;
            return add;
        }
        if (operatorString.equals("-")) {
            IntBinaryOperator subtract = (left, right) -> left - right;
            return subtract;
        }
        if (operatorString.equals("*")) {
            IntBinaryOperator multiply = (left, right) -> left * right;
            return multiply;
        }
        if (operatorString.equals("/")) {
            IntBinaryOperator divide = (left, right) -> left / right;
            return divide;
        }
        throw new IllegalArgumentException("Unvalid Operator");
    }
}
