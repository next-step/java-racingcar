public class ValidationUtils {

    private static final int STOPABLE_MIN = 0;
    private static final int STOPABLE_MAX = 3;
    private static final int RUNNABLE_MIN = 4;
    private static final int RUNNABLE_MAX = 9;

    private static final int POSSIBLE_NAME_LENGTH = 5;

    public static boolean isRun(int random) {
        return RUNNABLE_MIN <= random && random <= RUNNABLE_MAX;
    }

    public static boolean isName5CharsOrLess(String name) {
        return name.length() <= POSSIBLE_NAME_LENGTH;
    }
}
