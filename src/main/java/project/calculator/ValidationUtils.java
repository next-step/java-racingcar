package project.calculator;

public class ValidationUtils {

    public static void assertNull(Object object) {
        if (object == null) {
            throw new NullPointerException();
        }
    }

    public static boolean isNumeric(String strNum) {
        return strNum.matches("-?\\d+(\\.\\d+)?");
    }
}
