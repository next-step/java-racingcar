package step3;

public class StringUtil {

    public static String repeat(String string, int printCount) {
        StringBuffer stringBuffer = new StringBuffer();

        for (int i = 0; i < printCount; i++) {
            stringBuffer.append(string);
        }

        return stringBuffer.toString();
    }
}
