package game;

public class ResultView {

    public final static String LOG = "-";

    public final static String LOG_DISPLAY = LOG;

    /**
     * 경기 결과 화면 출력
     *
     * @param result
     */
    public void racingResultView(int[] result) {

        for (int i = 0; i < result.length; i++) {
            printView(result[i], LOG_DISPLAY);
        }
        printLine();
    }

    /**
     * 입력 문자 횟수 만큼 화면에 출력
     * @param displayCount
     * @param logDisplay
     */
    public void printView(int displayCount, String logDisplay) {

        for (int i = 0; i < displayCount; i++) {
            System.out.print(logDisplay);
        }

        printLine();
    }

    /**
     * 빈 라인 출력
     */
    public void printLine() {
        System.out.println("");
    }

    public static ResultView create() {
        return new ResultView();
    }
}
