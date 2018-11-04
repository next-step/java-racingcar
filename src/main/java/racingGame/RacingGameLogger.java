package racingGame;

import java.util.ArrayList;

public class RacingGameLogger {
    private String POSITION_MARKER = "-";

    public void log(ArrayList<Integer> carPositions) {
        for (int i = 0, len = carPositions.size(); i < len; i++) {
            printCarPosition(carPositions.get(i));
        }
        System.out.println();
    }

    private void printCarPosition(int position) {
        String strPosition = new String(new char[position]).replace("\0", this.POSITION_MARKER);
        System.out.println(strPosition);
    }
}
