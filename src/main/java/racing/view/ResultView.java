package racing.view;


import racing.board.GameResult;
import racing.model.RacingCar;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ResultView {

    private static final String CHAR_TO_CONVERT = "-";

    public static void viewGameStart() {
        System.out.println("\n실행 결과");
    }

    public static void viewRunningStep(String name, Integer position) {
        System.out.println(name + " : " + convertPosition(position));
    }

    private static String convertPosition(int position) {
        return IntStream.range(0, position)
                .mapToObj(p -> CHAR_TO_CONVERT)
                .collect(Collectors.joining());
    }

    public static void viewEndingOfStep() {
        System.out.println();
    }

    public static void viewWinners(GameResult gameResult) {
        System.out.printf("%s가 최종 우승했습니다.\n ", gameResult.getWinners()
                .stream()
                .map(RacingCar::toString)
                .collect(Collectors.joining(", ")));
    }
}
