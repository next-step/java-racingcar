package study;

/**
 * Created by wyparks2@gmail.com on 2019-06-15
 * Blog : http://wyparks2.github.io
 * Github : http://github.com/wyparks2
 */
public class StringCalculator {

    public int calculate(String input) {
        String[] splitInputs = input.split(" ");
        return calculate(splitInputs);

    }

    private int calculate(String[] splitInputs) {
        int total = Integer.parseInt(splitInputs[0]);

        for (int index = 1; index < splitInputs.length; index += 2) {
            int left = total;
            int right = Integer.parseInt(splitInputs[index + 1]);
            CalculatorOperator operator = CalculatorOperator.fromString(splitInputs[index]);
            total = operator.calculate(left, right);
        }

        return total;
    }
}
