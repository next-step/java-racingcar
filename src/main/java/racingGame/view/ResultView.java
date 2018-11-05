package racingGame.view;

import java.util.ArrayList;

public class ResultView {
    private static String POSITION_MARKER = "-";

    public static void log(ArrayList<Integer> carPositions) {
        for (int carPosition : carPositions) {
            printCarPosition(carPosition);
        }
        System.out.println();
    }

    private static void printCarPosition(int position) {
        String strPosition = new String(new char[position]).replace("\0", POSITION_MARKER);
        System.out.println(strPosition);
    }
}
