package autoracing.domain;

public class AssertUtils {
    public static void assertNotNull(Object o, String nullMessage) {
        if (o == null) {
            throw new NullPointerException(nullMessage);
        }
    }
}
