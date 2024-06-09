package core.game;

import core.car.Car;
import java.util.List;

public interface GameInterface {

  Game createGame(List<Car> cars);

  void runGame(Game game);
}
