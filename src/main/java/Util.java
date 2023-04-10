public class Util {
    public static boolean isNullOrBlank(String input) {
        return  input == null || input.isEmpty();
    }

    public static int convertInput(String input) {
        return Integer.parseInt(input);
    }

    public static String[] split(String input, String delimiter) {
        return input.split(delimiter);
    }
}
