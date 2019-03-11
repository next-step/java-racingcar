package racing.ui;

import racing.view.RacingCarsView;

import java.util.List;

public class GameConsole {
    private static final String RESULT_COMMENT = "실행결과";
    private static final String RACING_CAR = "-";

    public static void preView(RacingCarsView view) {
        System.out.println(RESULT_COMMENT);
        resultView(view);
    }

    private static void resultView(RacingCarsView view) {
        view.getPositions().stream().forEach(position -> showCar(position));
        emptyLine();
    }

    public static void resultViews(List<RacingCarsView> views) {
        views.stream().forEach(view -> resultView(view));
    }

    private static void showCar(Integer position) {
        for (int i = 0; i < position; i++) {
            System.out.print(RACING_CAR);
        }
        emptyLine();
    }

    private static void emptyLine() {
        System.out.println();
    }
}
