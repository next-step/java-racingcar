package racingGame.view;

import java.util.List;
import java.util.Map;

public class ResultView {
    private static String POSITION_MARKER = "-";

    public static void logRace(Map<String, Integer> carNameAndPositionMap) {
        for (String carName : carNameAndPositionMap.keySet()) {
            printCarNameAndPosition(carName, carNameAndPositionMap.get(carName));
        }
        System.out.println();
    }

    public static void logChampion(List<String> championCarNames) {
        System.out.println(String.join(", ", championCarNames) + "가 최종 우승했습니다.");
    }

    private static void printCarNameAndPosition(String carName, int position) {
        String strPosition = new String(new char[position]).replace("\0", POSITION_MARKER);
        System.out.println(carName + " : " + strPosition);
    }
}
