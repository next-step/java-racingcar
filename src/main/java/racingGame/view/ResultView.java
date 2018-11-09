package racingGame.view;

import racingGame.domain.RacingCarDTO;

import java.util.List;

public class ResultView {
    private static String POSITION_MARKER = "-";
    private static String NAME_DELIMITER = ", ";

    public static void logRace(List<RacingCarDTO> snapshots) {
        for (RacingCarDTO snapshot : snapshots) {
            printCarNameAndPosition(snapshot.getName(), snapshot.getPosition());
        }
        System.out.println();
    }

    public static void logChampion(List<String> championCarNames) {
        printChampion(championCarNames);
    }

    private static void printCarNameAndPosition(String carName, int position) {
        String strPosition = new String(new char[position]).replace("\0", POSITION_MARKER);
        System.out.println(carName + " : " + strPosition);
    }

    private static void printChampion(List<String> carNames) {
        System.out.println(String.join(NAME_DELIMITER, carNames) + "가 최종 우승했습니다.");
    }
}
