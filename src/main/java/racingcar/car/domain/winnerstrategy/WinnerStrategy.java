package racingcar.car.domain.winnerstrategy;

import racingcar.car.domain.Car;
import java.util.List;

public interface WinnerStrategy {

    List<Car> getWinners(List<Car> cars);
}
