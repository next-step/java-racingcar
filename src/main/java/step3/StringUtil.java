package step3;

public class StringUtil {

    public static String printToHyphen(int printCount) {
        StringBuffer stringBuffer = new StringBuffer();

        for (int i = 0; i < printCount; i++) {
            stringBuffer.append("-");
        }

        return stringBuffer.toString();
    }
}
