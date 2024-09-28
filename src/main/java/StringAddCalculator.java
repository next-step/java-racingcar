import utils.validator.Validator;

public class StringAddCalculator {
    public static int splitAndSum(String text) {

        if (!Validator.validateUserInput(text)) {
            return 0;
        }

        return sum(split(text));
    }

    private static int sum(int[] numbers) {
        int ret = 0;
        for (int number : numbers) {
            ret += number;
        }
        return ret;
    }

    private static int[] toInts(String[] numbers) {
        int[] ret = new int[numbers.length];
        for (int i = 0 ; i < numbers.length ; i++) {
            ret[i] = Integer.parseInt(numbers[i]);
        }
        return ret;
    }

    private static int[] split(String text) {
        return toInts(text.split(",|:"));
    }
}
