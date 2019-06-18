package study.calculator;

/**
 * Created by wyparks2@gmail.com on 2019-06-15
 * Blog : http://wyparks2.github.io
 * Github : http://github.com/wyparks2
 */
public class StringCalculator {

    public int calculate(String input) {
        validation(input);

        return calculate(splitByBlank(input));
    }

    private int calculate(String[] splitInputs) {
        int total = Integer.parseInt(splitInputs[0]);

        final int LENGTH = splitInputs.length;
        for (int index = 1; index < LENGTH; index += 2) {
            int left = total;
            int right = Integer.parseInt(splitInputs[index + 1]);
            CalculatorOperator operator = CalculatorOperator.fromString(splitInputs[index]);

            total = operator.calculate(left, right);
        }

        return total;
    }

    private String[] splitByBlank(String source) {
        return source.split(" ");
    }

    private void validation(String source) {
        if (source == null)
            throw new IllegalArgumentException("입력 값이 null 입니다.");

        if (source.replaceAll(" ", "").length() == 0)
            throw new IllegalArgumentException("입력 값이 빈 공백 문자입니다.");
    }
}
