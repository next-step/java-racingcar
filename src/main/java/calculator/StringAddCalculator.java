package calculator;

public class StringAddCalculator {

    public static int splitAddSum(String text) {
        if (text == null || text.isEmpty() ) {
            return 0;
        }
        return sum(toInts(split(text)));
    }

    private static int[] toInts(String[] value) {
        int[] numbers = new int[value.length];
        for (int i = 0; i < value.length; i++) {
            numbers[i] = Positive.toInt(value[i]);
        }
        return numbers;
    }

    private static String[] split(String text) {
        return Delimiter.split(text);
    }

    private static int sum(int[] numbers) {
        int result = 0;
        for (Integer number : numbers) {
            result += number;
        }
        return result;
    }



}
