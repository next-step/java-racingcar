package stringcalculator;

public class StringCalculator {
    public int calculateAll(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("유효하지 않은 입력값입니다!");
        }

        String[] args = input.split(" ");

        int result = Integer.parseInt(args[0]);
        for (int i = 1; i < args.length; i += 2) {
            result = calculate(result, args[i], Integer.parseInt(args[i + 1]));
        }

        return result;
    }

    private int calculate(int result, String operator, int operand) {
        if ("+".equals(operator)) {
            return result + operand;
        }
        if ("-".equals(operator)) {
            return result - operand;
        }
        if ("*".equals(operator)) {
            return result * operand;
        }
        if ("/".equals(operator)) {
            return result / operand;
        }
        throw new IllegalArgumentException("사칙연산 기호가 아닙니다");
    }
}
