package racingcar;

import racingcar.domain.Car;

public interface MovingStrategy {

  int getRandNum();

  int move(Car car, int randomInt, int criteriaNum);
}
