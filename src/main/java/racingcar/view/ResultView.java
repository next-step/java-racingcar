package racingcar.view;

public class ResultView {
    private static final String RESULT_MESSAGE = "실행결과";
    private static final String POSITION_MARK = "-";

    private ResultView() {
    }

    public static void printResultMessage() {
        System.out.println("\n" + RESULT_MESSAGE + "\n");
    }

    public static void printPositionMark(int position) {
        System.out.println(POSITION_MARK.repeat(position));
    }
}
