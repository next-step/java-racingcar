import java.util.ArrayList;
import java.util.List;

public class NumberOperator {

    private int value;

    public NumberOperator() {
        this.value = 0;
    }

    public int getValue() {
        return value;
    }

    public int sum(int number) {
        validateNegative(number);
        value += number;

        return value;
    }

    private void validateNegative(int number) {
        if (number < 0) {
            throw new RuntimeException();
        }
    }

    public static List<Integer> parseIntList(String[] numbers) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < numbers.length; i++) {
            result.add(stringToInt(numbers[i]));
        }

        return result;
    }

    private static int stringToInt(String numberStr) {
        if (!numberStr.isBlank()) {
            return Integer.parseInt(numberStr);
        }

        return 0;
    }
}
