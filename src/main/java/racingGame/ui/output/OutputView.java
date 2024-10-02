package racingGame.ui.output;

import racingGame.model.car.Car;

import java.util.List;

public interface OutputView {
    void printCarGraph(List<Car> cars);
    void printInitMessage();
}
