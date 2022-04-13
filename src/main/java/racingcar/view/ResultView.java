package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Histories;
import racingcar.domain.History;
import racingcar.domain.Round;

import java.util.List;

public class ResultView {

    private static final String MESSAGE_RESULT = "실행결과";

    public static void renderResultView(Histories histories) {
        System.out.println(MESSAGE_RESULT);
        histories.getHistories()
                .forEach(history -> renderResult(history.getCars(), history.getRound()));
    }

    private static void renderResult(List<Car> cars, Round round) {
        for (Car car : cars) {
            System.out.println(new ResultBuilder(car.getPosition()).build());
        }
        System.out.println("[ROUND " + round.getCurrentRound() + " END]");
    }

}
