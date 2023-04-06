package calculator;

public class Operator {
    public static int sum(String[] numbers) {
        int sum = 0;
        for (String s : numbers) {
            int number = Integer.parseInt(s);
            if (IntValidator.isPositive(number)) {
                sum += number;
            }
        }
        return sum;
    }
}
