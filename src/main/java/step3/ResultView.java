package step3;

import static step3.Constants.POSITION_MARKER;
import static step3.Constants.RESULT_TITLE;

public class ResultView {

    public void printTitle() {
        System.out.println(RESULT_TITLE);
    }
    public void printResult(int[] carPositions) {
        for (int i = 0; i < carPositions.length; ++i) {
            printCarPosition(carPositions[i]);
        }
    }

    public void printCarPosition(int position) {
        for (int i = 0; i < position; ++i) {
            System.out.print(POSITION_MARKER);
        }
        System.out.println();
    }
}
