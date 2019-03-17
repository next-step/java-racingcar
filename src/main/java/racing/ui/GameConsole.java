package racing.ui;

import com.google.common.base.Strings;
import racing.view.RacingCarDto;
import racing.view.RacingCarsDto;
import racing.view.RacingGameResultView;

import java.util.List;

public class GameConsole {
    private static final String RESULT_COMMENT = "실행결과";
    private static final String RACING_CAR = "-";
    private static final String RESULT_WINNER_COMMENT = " 가 최종 우승했습니다.";

    public static void initShow(RacingCarsDto view) {
        System.out.println(RESULT_COMMENT);
        processShow(view);
    }

    public static void processShow(RacingCarsDto views) {
        views.stream().forEach(v -> show(v));
        emptyLine();
    }

    public static void resultShow(RacingGameResultView result) {
        initShow(result.getFirstHistory());
        historyShow(result.getHistory());
        System.out.println(result.getWinners() + RESULT_WINNER_COMMENT);
    }

    private static void show(RacingCarDto view) {
        showName(view);
        showCarMovement(view);
    }

    private static void showName(RacingCarDto view) {
        System.out.print(view.getCarName() + " : ");
    }

    private static void showCarMovement(RacingCarDto view) {
        System.out.println(Strings.repeat(RACING_CAR, view.getPosition()));
    }

    private static void emptyLine() {
        System.out.println();
    }

    private static void historyShow(List<RacingCarsDto> history) {
        history.stream().forEach(h -> processShow(h));
    }
}
