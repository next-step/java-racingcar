public class Calculator {
    public static int cal(String input) {
        if (isEmptyOrNull(input)) {
            return 0;
        }

        if (input.contains(",") || input.contains(":")) {
            return toInt(splitByCommaOrColon(input));
        }
        return toInt(splitByCommaOrColon(input));
    }

    private static String[] splitByCommaOrColon(String input) {
        return input.split(",|:");
    }

    private static boolean isEmptyOrNull(String input) {
        return input == null || input.isBlank();
    }

    private static int toInt(String[] strings) {
        int sum = 0;
        for (String string : strings) {
            isStringValid(string);
            sum += Integer.parseInt(string);
        }

        return sum;
    }

    private static void isStringValid(String string) {
        if (Integer.parseInt(string) < 0 || !isNumeric(string)) {
            throw new IllegalArgumentException("The input string is not valid");
        }
    }

    public static boolean isNumeric(String string) {
        try {
            Integer.parseInt(string);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }
}
