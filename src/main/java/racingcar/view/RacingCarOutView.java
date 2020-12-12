package racingcar.view;

public class RacingCarOutView {
    private static final String RESULT_HEADER = "실행결과";

    public static void showResult(StringBuilder result) {
        System.out.println(RESULT_HEADER);
        System.out.println(result);
    }
}
