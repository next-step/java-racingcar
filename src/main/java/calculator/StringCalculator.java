package calculator;

public class StringCalculator {

    public static int toInt(String stringNumber) {
        return Integer.parseInt(stringNumber);
    }

    public static int calculate(String input) {
        int result = 0;
        String[] numbers = input.split(",|:");
        for (String number : numbers) {
            result += toInt(number);
        }
        return result;
    }
}
