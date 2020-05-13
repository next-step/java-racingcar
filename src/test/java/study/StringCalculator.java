package study;

public class StringCalculator {

    public double calculate(String equation) {
        validate(equation);

        String[] parsed = equation.trim().split(" ");

        double result = 0;
        int firstOperatorIndex = 0;

        if (isNumeric(parsed[0])) {
            result = Double.parseDouble(parsed[0]);
            firstOperatorIndex = 1;
        }

        for (int i = firstOperatorIndex; i < parsed.length; i += 2) {
            String operator = parsed[i];
            double operand = Double.parseDouble(parsed[i + 1]);

            switch (operator) {
                case "+":
                    result += operand;
                    break;

                case "-":
                    result -= operand;
                    break;

                case "*":
                    result *= operand;
                    break;

                case "/":
                    result /= operand;
                    break;

                default:
                    throw new IllegalArgumentException("사칙연산 기호가 아닙니다 : " + operator);
            }
        }

        return result;
    }

    private boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private void validate(String equation) {
        if (equation == null || equation.trim().isEmpty()) {
            throw new IllegalArgumentException("입력값은 null이거나 빈 공백일 수 없습니다.");
        }
    }
}
