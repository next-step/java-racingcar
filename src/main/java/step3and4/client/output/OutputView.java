package step3and4.client.output;

import step3and4.game.car.Cars;

@FunctionalInterface
public interface OutputView {

    void print(Cars cars);

}
