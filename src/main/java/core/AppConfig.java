package core;

import core.car.CarImpl;
import core.car.CarInterface;
import core.game.GameImpl;
import core.game.GameInterface;
import core.user.UserImpl;
import core.user.UserInterface;
import core.util.Util;

public class AppConfig {

  Util util;

  public AppConfig(Util util) {
    this.util = util;
  }

  public CarInterface carInterface() {
    return new CarImpl(util);
  }

  public UserInterface userInterface() {
    return new UserImpl(util);
  }

  public GameInterface gameInterface(CarInterface carImpl) {
    return new GameImpl(util, carImpl);
  }
}
