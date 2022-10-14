package step3and4and5.client.output;

import step3and4and5.game.car.Cars;
import step3and4and5.game.car.WinningCars;

public interface OutputView {

    void print(Cars cars);

    void print(WinningCars winningCars);

}
