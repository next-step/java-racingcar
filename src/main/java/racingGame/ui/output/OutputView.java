package racingGame.ui.output;

import racingGame.model.car.Car;
import racingGame.model.car.CarMovement;
import racingGame.model.car.Cars;

import java.util.List;

public interface OutputView {
    void printCarGraph(CarMovement cars);
    void printInitMessage();
    void printWinners(List<Car> cars);
}