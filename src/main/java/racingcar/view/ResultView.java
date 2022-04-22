package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Histories;
import racingcar.domain.Round;
import racingcar.domain.input.CarName;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    private static final String MESSAGE_CURRENT_ROUND_END = "END ROUND ";
    private static final String MESSAGE_RESULT = "실행결과";
    private static final String MESSAGE_WIN = "가 최종 우승했습니다.";

    private static final String WINNERS_DELIMITER = ", ";
    private static final String BLANK_LINE = "";

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
                .map(Car::carName)
                .map(CarName::toString)
                .collect(Collectors.joining(WINNERS_DELIMITER));
        System.out.println(winnerNames + MESSAGE_WIN);
    }

    private static void renderResult(List<Car> cars, Round round) {
        for (Car car : cars) {
            System.out.println(new ResultBuilder(car.position().get(), car.carName()).build());
        }
        System.out.println(BLANK_LINE);
        System.out.println(MESSAGE_CURRENT_ROUND_END + round.currentRound().get());
        System.out.println(BLANK_LINE);
    }

}
