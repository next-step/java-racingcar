package racingcar.view.result;

import racingcar.domain.Car;

import java.util.List;

public interface ResultView {
    void printRoundResult(List<Car> carList);
    void printWinner(List<Car> carList);
}
