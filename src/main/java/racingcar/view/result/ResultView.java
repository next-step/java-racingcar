package racingcar.view.result;

import racingcar.domain.Car;

import java.util.List;

public interface ResultView {
    void printRoundResult(Car car);
    void printWinner(List<Car> winners);
}
