package racingcar.view.console;

import racingcar.domain.car.Car;
import racingcar.view.util.ResultView;

import java.util.List;

public class OutputView {

    public static void showStatus(List<Car> cars, int turn) {
        ResultView.result(cars, turn);
    }

    public static void showWinner(List<Car> winners) {
        System.out.println(ResultView.winner(winners));
    }
}
