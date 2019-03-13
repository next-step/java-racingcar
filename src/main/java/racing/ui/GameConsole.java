package racing.ui;

import com.google.common.base.Strings;
import racing.application.RacingGameResult;
import racing.view.RacingCarView;
import racing.view.RacingCarsView;

import java.util.List;

public class GameConsole {
    private static final String RESULT_COMMENT = "실행결과";
    private static final String RACING_CAR = "-";
    private static final String RESULT_WINNER_COMMENT = " 가 최종 우승했습니다.";

    public static void initShow(RacingCarsView view) {
        System.out.println(RESULT_COMMENT);
        processShow(view);
    }

    public static void processShow(RacingCarsView views) {
        views.stream().forEach(v -> show(v));
        emptyLine();
    }

    public static void resultShow(RacingGameResult result) {
        historyShow(result.getHistory());
        System.out.println(result.getWinners() + RESULT_WINNER_COMMENT);
    }

    private static void show(RacingCarView view) {
        showName(view);
        showCarMovement(view);
    }

    private static void showName(RacingCarView view) {
        System.out.print(view.getCarName() + " : ");
    }

    private static void showCarMovement(RacingCarView view) {
        System.out.println(Strings.repeat(RACING_CAR, view.getPosition()));
    }

    private static void emptyLine() {
        System.out.println();
    }

    private static void historyShow(List<RacingCarsView> history) {
        history.stream().forEach(h -> processShow(h));
    }
}
