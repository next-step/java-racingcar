package racing.view;


import racing.board.GameResult;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ResultView {

    private static final String CHAR_TO_CONVERT = "-";

    public static void viewWinners(GameResult gameResult) {
        System.out.println(gameResult.getWinnerNames() + "가 최종 우승했습니다.");
    }

    public static void viewGameStart() {
        System.out.println("\n실행 결과");
    }

    public static void viewRunningStep(String name, Integer position) {
        System.out.println(name + " : " + convertPosition(position));
    }

    public static void viewEndingOfStep() {
        System.out.println();
    }

    private static String convertPosition(int position) {
        return IntStream.range(0, position)
                .mapToObj(p -> CHAR_TO_CONVERT)
                .collect(Collectors.joining());
    }

}
