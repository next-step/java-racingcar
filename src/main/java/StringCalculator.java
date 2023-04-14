import java.util.List;

public class StringCalculator {
    public static final long DEFAULT_RESULT = 0L;
    public static final String ERROR_NEGATIVE_NUMBER = "Negative number was given";

    public static Long sumOfNumbers(String input) {
        if (isNullOrEmpty(input)) return DEFAULT_RESULT;
        var stringCalculatorInput = new StringCalculatorInput(input);
        checkAllNumbersArePositive(stringCalculatorInput.getNumbers());
        return sum(stringCalculatorInput.getNumbers());
    }


    private static Boolean isNullOrEmpty(String str) {
        return (str == null || str.isEmpty());
    }


    private static void checkAllNumbersArePositive(List<Long> numbers) {
        for (var number : numbers) {
            checkNumberIsPositive(number);
        }
    }

    private static void checkNumberIsPositive(Long number) {
        if (number < 0) {
            throw new RuntimeException(ERROR_NEGATIVE_NUMBER);
        }
    }

    private static Long sum(List<Long> longs) {
        var sum = 0L;
        for (var element : longs) {
            sum += element;
        }
        return sum;
    }
}
