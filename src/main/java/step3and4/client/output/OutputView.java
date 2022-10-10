package step3and4.client.output;

import step3and4.game.car.Cars;
import step3and4.game.car.WinningCars;

public interface OutputView {

    void print(Cars cars);

    void print(WinningCars winningCars);

}
