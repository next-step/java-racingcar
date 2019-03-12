package racing.ui;

import racing.view.RacingCarView;
import racing.view.RacingCarsView;

import java.util.List;
import java.util.stream.Collectors;

public class GameConsole {
    private static final String RESULT_COMMENT = "실행결과";
    private static final String RACING_CAR = "-";
    private static final String RESULT_WINNER_COMMENT = " 가 최종 우승했습니다.";

    public static void preView(RacingCarsView view) {
        System.out.println(RESULT_COMMENT);
        resultView(view);
    }

    public static void resultViews(List<RacingCarsView> views) {
        views.stream().forEach(view -> resultView(view));
    }

    private static void resultView(RacingCarsView views) {
        views.stream().forEach(v -> show(v));
        emptyLine();
    }

    private static void show(RacingCarView view) {
        showName(view);
        showCar(view);
        emptyLine();
    }

    private static void showName(RacingCarView view) {
        System.out.print(view.getCarName() + " : ");
    }

    private static void showCar(RacingCarView view) {
        for (int i = 0; i < view.getPosition(); i++) {
            System.out.print(RACING_CAR);
        }
    }

    private static void emptyLine() {
        System.out.println();
    }

    public static void winnersView(List<String> winners) {
        String convertedWinners = winners.stream().collect(Collectors.joining(","));
        System.out.println(convertedWinners + RESULT_WINNER_COMMENT);
    }
}
