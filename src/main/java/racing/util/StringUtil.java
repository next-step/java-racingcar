package racing.util;

public class StringUtil {

    public static String makeRepeatString(int length, String element) {
        return String.valueOf(new char[length]).replace("\0", element);
    }

}
