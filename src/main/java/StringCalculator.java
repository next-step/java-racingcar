import java.util.function.IntBinaryOperator;

public class StringCalculator {
    public int getMathAnswer(String params) {
        if (params == null || params.length() == 0) {
            throw new IllegalArgumentException("Unvalid parameter");
        }
        String[] strings = params.split(" ");
        int answer = Integer.parseInt(strings[0]);
        answer = calculate(strings, answer);
        return answer;
    }

    private int calculate(String[] strings, int result) {
        int index = 1;
        IntBinaryOperator binaryOperator;
        while (index < strings.length) {
            if ("+-*/".contains(strings[index])) {
                binaryOperator = getOperator(strings[index]);
                result = binaryOperator.applyAsInt(result, Integer.parseInt(strings[index +1]));
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
            return (left, right) -> left + right;
        }
        if (operatorString.equals("-")) {
            return (left, right) -> left - right;
        }
        if (operatorString.equals("*")) {
            return (left, right) -> left * right;
        }
        if (operatorString.equals("/")) {
            return (left, right) -> left / right;
        }
        throw new IllegalArgumentException("Unvalid Operator");
    }
}
