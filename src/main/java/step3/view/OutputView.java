package step3.view;

import step3.game.Car;

import java.util.List;
import java.util.Set;

public interface OutputView {

    void result();

    String carDistance(Integer distance);

    void finalResult(Set<Car> carInfo);

    void endOfThisTurn(Set<Car> cars);
}
