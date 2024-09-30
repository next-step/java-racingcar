package race.Utils;

public class ResultUtils {
    public static final String EXECUTION = "\n실행 결과";

    private ResultUtils() {
        throw new AssertionError("생성자 호출 금지");
    }

    public static void printResultView() {
        System.out.println(EXECUTION);
    }
}
