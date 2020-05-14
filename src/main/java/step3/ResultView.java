package step3;

import java.util.Collections;
import java.util.List;

public class ResultView {

    private static final String PROGRESS_DELEMETER = "";
    private static final String PROGRESS_INDICATOR = "-";

    private static final String RESULT_TITLE = "======= 실행 결과 =======";

    public static void printPosition(List<Integer> carPosition) {
        System.out.println(RESULT_TITLE);
        carPosition.stream()
                .map(ResultView::getResultiew)
                .forEach(System.out::println);
    }

    private static String getResultiew(int moveCount) {
        return String.join(PROGRESS_DELEMETER, Collections.nCopies(moveCount, PROGRESS_INDICATOR));
    }
}
