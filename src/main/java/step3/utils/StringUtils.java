package step3.utils;

public class StringUtils {

    public static boolean isBlank(String name) {
        if(name == null || name.equals(" ") || name.equals("")) {
            return true;
        }
        return false;
    }

    public static String repeat(String str, int repeatNum) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0 ; i < repeatNum ; i++) {
            sb.append(str);
        }
        return sb.toString();
    }
}
