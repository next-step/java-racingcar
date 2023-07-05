package racingcar.car.domain.winnerstrategy;

import racingcar.car.domain.Car;
import java.util.List;

/**
 * 게임 우승자 선출 전략.
 */
public interface WinnerStrategy {

    List<Car> getWinners(List<Car> cars);
}
