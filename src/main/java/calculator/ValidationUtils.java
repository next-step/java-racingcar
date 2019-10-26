package calculator;

public class ValidationUtils {

    public static void assertNull(Object object) {
        if (object == null) {
            throw new NullPointerException();
        }
    }
}
