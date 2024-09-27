public class StringAddCalculator {
    public static void validNegative(int num) throws RuntimeException {
        if (num < 0) {
            throw new RuntimeException();
        }
    }

    public static int emptyOrNull(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }
        return 1;
    }

    public static int processOneNumberString(String input) {
        return Integer.parseInt(input);
    }

    public static int splitAndSumWithComma(String input) {
        String[] splited = input.split(",");
        int summation = 0;
        for (String s : splited) {
            summation += Integer.parseInt(s);
        }
        return summation;
    }
}
