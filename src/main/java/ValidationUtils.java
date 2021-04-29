public class ValidationUtils {

    private static final int STOPABLE_MIN = 0;
    private static final int STOPABLE_MAX = 3;
    private static final int RUNNABLE_MIN = 4;
    private static final int RUNNABLE_MAX = 9;

    public static boolean isRun(int random) {
        return RUNNABLE_MIN <= random && random <= RUNNABLE_MAX;
    }
}
