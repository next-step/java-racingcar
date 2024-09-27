package calculator;

public class StringAdditionCalculator {

    public static int calculate(String input) {
        String[] numbers = input.split(",");
        int result = 0;
        for (String number : numbers) {
            result += Integer.parseInt(number);
        }
        return result;
    }
}
