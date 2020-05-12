package racingcar;

import java.util.ArrayList;

public class ResultView {

    private String POSITION_BAR = "-";

    public void printResult(ArrayList<Racingcar> carPositions) {
        for (Racingcar racingcar : carPositions) {
            int position = racingcar.getCarMovePosition();
            printPositionBar(position);
        }
        System.out.println();
    }

    private void printPositionBar(int position) {
        StringBuffer resultBar = new StringBuffer();
        for (int i = 0; i < position; i++) {
            resultBar.append(POSITION_BAR);
        }
        System.out.println(resultBar.toString());
    }
}
