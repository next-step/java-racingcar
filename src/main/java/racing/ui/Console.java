package racing.ui;

import racing.view.RacingCarsView;

public class Console {
    private static final String RESULT_COMMENT = "실행결과";
    private static final String RACING_CAR = "-";

    public static void preView(RacingCarsView view) {
        System.out.println(RESULT_COMMENT);
        resultView(view);
    }

    public static void resultView(RacingCarsView view) {
        view.getPositions().stream().forEach(v -> showCar(v));
        emptyLine();
    }

    private static void showCar(Integer v) {
        for (int i = 0; i < v; i++) {
            System.out.print(RACING_CAR);
        }
        emptyLine();
    }

    private static void emptyLine() {
        System.out.println();
    }
}
