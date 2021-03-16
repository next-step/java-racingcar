package step3.util;

public class StringUtil {

    public static String repeat(String string, int printCount) {
        StringBuffer stringBuffer = new StringBuffer();

        for (int i = 0; i < printCount; i++) {
            stringBuffer.append(string);
        }

        return stringBuffer.toString();
    }

    public static String[] split(String delimiter, String inputString) {
        if (isIllegalArgument(inputString)) {
            throw new IllegalArgumentException();
        }
        return inputString.split(delimiter);
    }

    private static boolean isIllegalArgument(String inputString) {
        return inputString == null || "".equals(inputString.trim()) ? true : false;
    }
}
