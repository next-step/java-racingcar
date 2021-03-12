package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

public interface OutputView {
    void printTitle();
    void printSingleRacingResult(List<Car> cars);
    void printWinners(List<String> winnersName);
}
