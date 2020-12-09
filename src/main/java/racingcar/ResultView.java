package racingcar;

import java.util.ArrayList;
import java.util.List;

public class ResultView {

    private static final String RESULT_DASH = "-";

    /**
     * 현재 결과를 출력합니다
     */
    public void printResult(RacingCarController racingCarController) {
        for (int distance : racingCarController.getNowDistance()) {
            this.printDash(distance);
        }
    }

    /**
     * 주어진 거리만큼 '-'를 출력합니다.
     * @param distance
     */
    private void printDash(int distance) {
        for (int i = 0; i < distance; i++) {
            System.out.print(ResultView.RESULT_DASH);
        }
        System.out.println();
    }
}
