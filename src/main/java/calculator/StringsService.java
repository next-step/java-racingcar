package calculator;


public class StringsService {

    public static boolean isBlank(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("input is null or blank");
        } else {
            return true;
        }
    }

    public static String[] splitString(String str) {
        return str.split(" ");
    }

    public static boolean checkSymbol(String[] splitBlank) {
        String pattern = "[\\d\\+\\-\\*\\/]";
        for (int i = 0; i < splitBlank.length; i++) {
            if (splitBlank[i].matches(pattern)) {
                return true;
            }
        }
        throw new IllegalArgumentException("symbol error");

    }

    public static int calculateSplitedString(String[] input) {
        int result = Integer.parseInt(input[0]);
        for (int i = 0; i < input.length - 2; i += 2) {
            result = Operation.result(String.valueOf(input[i + 1].charAt(0)), result, Integer.parseInt(input[i + 2]));
        }
        return result;
    }

}
