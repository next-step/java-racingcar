package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

public interface ResultView {
    void printStart();

    void printRoundResult(List<Car> cars);

    void printWinner(List<String> winnerNames);
}
