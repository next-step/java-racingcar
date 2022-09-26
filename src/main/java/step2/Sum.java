package step2;

public class Sum {

    public static int addAllValuesInIntArray(int[] numbers) {
        int result = 0;
        for (int number : numbers) {
            checkPositiveNumber(number);
            result += number;
        }
        return result;
    }

    private static void checkPositiveNumber(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("음수값이 들어올 수 없습니다.");
        }
    }
}
