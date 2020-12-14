package lotto;

public class StringUtil {

    public static boolean isEmpty(String string) {
        return string == null || string.equals("") || string.trim().equals("");
    }

    public static boolean isNumber(String text) {
        try {
            Integer.parseInt(text);
            return true;
        } catch (NullPointerException | NumberFormatException e) {
            return false;
        }
    }

}
