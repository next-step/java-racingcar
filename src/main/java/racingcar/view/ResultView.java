package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Histories;
import racingcar.domain.Round;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    private static final String MESSAGE_RESULT = "실행결과";

    private ResultView() { }

    public static void renderResultView(Histories histories) {
        System.out.println(MESSAGE_RESULT);
        histories.getHistories()
                .forEach(history -> renderResult(history.getCars(), history.getRound()));
        renderWinner(histories);
    }

    private static void renderWinner(Histories histories) {
        List<Car> winners = histories.findWinners();
        String winnerNames = winners.stream()
                .map(Car::getCarName)
                .collect(Collectors.joining(", "));
        System.out.println(winnerNames + "가 최종 우승했습니다.");
    }

    private static void renderResult(List<Car> cars, Round round) {
        for (Car car : cars) {
            System.out.println(new ResultBuilder(car.getPosition(), car.getCarName()).build());
        }
        System.out.println("[ROUND " + round.getCurrentRound() + " END]");
        System.out.println("");
    }

}
