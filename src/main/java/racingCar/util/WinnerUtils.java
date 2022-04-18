package racingCar.util;

import racingCar.model.Car;
import racingCar.model.Position;
import racingCar.model.Winner;

public final class WinnerUtils {

  public static Winner getChallenger(Car car) {
    String[] winnerSplit = StringUtils.split(car.toString(), " : ");
    return new Winner(winnerSplit[0], new Position(winnerSplit[1].length()));
  }

}
