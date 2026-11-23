package racingcar.view;

import racingcar.domain.CarName;
import racingcar.domain.Cars;

import java.util.List;

public class ResultView {
    private ResultView() {
    }

    public static void showResultTitle() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public static void showRound(Cars cars) {
        System.out.println(ResultFormatter.formatRound(cars));
        System.out.println();
    }

    public static void showWinners(List<CarName> winners) {
        System.out.println(ResultFormatter.formatWinners(winners));
    }
}
