package learningstring;

public class StringUtil {

    public static String removeBracket(String input) {
        return input.replaceAll("[()]", "");
    }
}
