package calculator;

public class Calculator {

    public static int calculate(String text) {

        if (isBlank(text)) {
            return 0;
        }

        isMinus(text);

        return sum(toInts(split(text)));
    }

    private static void isMinus(String text) {
        if (Integer.parseInt(text) < 0) {
            throw new RuntimeException();
        }
    }

    private static boolean isBlank(String text) {
        return text == null || text.isBlank();
    }

    private static String[] split(String text) {
        return text.split(",|:");
    }

    private static int[] toInts(String[] split) {

        int[] ints = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            ints[i] = Integer.parseInt(split[i]);
        }

        return ints;
    }

    private static int sum(int[] numbers) {

        int result = 0;
        for (int n : numbers) {
            result += n;
        }
        return result;
    }


}
