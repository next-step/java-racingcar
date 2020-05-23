package racingcar.domain;

import java.util.List;
import racingcar.util.RandomUtil;

public class GameMock extends Game {

  private int attemptNum;

  private GameMock(Cars cars) {
    super(cars);
  }

  @Override
  public Cars doRace() {
    Cars cars = super.getCars();
    List<Car> carList = cars.getCarList();
    carList.forEach(element -> {
      int random = RandomUtil.getRandomValue();
      element.updatePosition(random);
    });
    attemptNum++;
    return cars;
  }

  public int getAttemptNum() {
    return attemptNum;
  }

  public static GameMock create(Cars cars) {
    return new GameMock(cars);
  }
}
