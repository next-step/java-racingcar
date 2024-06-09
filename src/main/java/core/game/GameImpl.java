package core.game;

import core.car.Car;
import core.car.CarInterface;
import core.util.Util;
import java.util.List;

public class GameImpl implements GameInterface {

  Util util;
  CarInterface carImpl;

  public GameImpl(Util util, CarInterface carImpl) {
    this.util = util;
    this.carImpl = carImpl;
  }

  @Override
  public Game createGame(List<Car> cars) {
    return new Game(cars);
  }

  @Override
  public void runGame(Game game) {
    game.getCars().forEach(car -> {
      Integer randomNum = util.getRandomNumFromZero(10);
      carImpl.goForward(car, randomNum);
      String printStr = car.getName() + " : " + carImpl.getDistanceWithString(car);
      System.out.println(printStr);
    });
  }
}
