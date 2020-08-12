package pobiRacingCar.utils;

public class StringUtils {
    
    public static boolean isNullOrBlank(String value) {
        return value == null || value.trim().isEmpty();
    }

    public static String repeat(String s, int i) {
        StringBuilder sb = new StringBuilder();
        for (int j = 0 ; j < i ; j++) {
            sb.append(s);
        }
        return sb.toString();
    }
}
