public class StringAddCalculator {

    public static int splitAndSum(String input) throws Exception {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        if (isNumeric(input)) {
            return Integer.parseInt(input);
        }

        return 1;
    }

    private static boolean isNumeric(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}
