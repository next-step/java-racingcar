package racingcar.view;

import racingcar.dto.Round;

import java.util.List;
import java.util.Map;

public class ResultView {

    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String RACE_TRACK = "-";
    private static final String CAR_NAME_DELIMITER = ": ";

    public static void printResultMessage() {
        System.out.println(RESULT_MESSAGE);
    }

    public static void printGameResult(List<Round> rounds) {
        for (Round round : rounds) {
            printRound(round);
        }
    }

    public static void printGameWinners(String winnersList) {
        System.out.println(winnersList + "가 최종 우승했습니다.");
    }

    public static void printRound(Round round) {
        for (Map.Entry<String, Integer> stringIntegerEntry : Round.roundResult(round).entrySet()) {
            printTrack(stringIntegerEntry);
        }
        System.out.println();
    }

    public static void printTrack(Map.Entry<String, Integer> roundResult) {
        StringBuilder sb = new StringBuilder();
        sb.append(roundResult.getKey()).append(CAR_NAME_DELIMITER);
        for (int i = 0; i < roundResult.getValue(); i++) {
            sb.append(RACE_TRACK);
        }
        System.out.println(sb.toString());
    }
}
