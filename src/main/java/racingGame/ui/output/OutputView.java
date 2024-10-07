package racingGame.ui.output;

import racingGame.model.car.CarMovement;

public interface OutputView {
    void printCarGraph(CarMovement cars);
    void printInitMessage();
}
