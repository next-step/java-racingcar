package step3.view.output;

import step3.game.car.Car;

import java.util.Set;

public interface OutputView {

    void result();

    String carDistance(Integer distance);

    void finalResult(Set<Car> carInfo);

    void endOfThisTurn(Set<Car> cars);
}
