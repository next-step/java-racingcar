package edu.nextstep.camp.view;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    private static final String TRACK = "#";
    private static final String TRIP = "-";
    private static final String CAR_DELIMITER = "\n";
    private static final String WINNER_DELIMITER = ",";

    public static void printResult(int turns, List<Integer> gameResult) {
        final String track = TRACK.repeat(turns);
        final String result = gameResult.stream()
                .map(TRIP::repeat)
                .collect(Collectors.joining(CAR_DELIMITER));
        System.out.println(track);
        System.out.println(result);
        System.out.println(track);
    }

    public static void printWinners(List<String> winners) {
        System.out.println(String.join(WINNER_DELIMITER, winners) + "가 최종 우승했습니다.");
    }
}
