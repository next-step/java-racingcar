package racingCar.util;

import racingCar.model.Car;
import racingCar.model.Position;
import racingCar.model.Winner;

public final class WinnerUtils {
  private static final String TOKEN = " : ";
  public static Winner getChallenger(Car car) {
    String[] winnerSplit = StringUtils.split(car.toString(), TOKEN);
    return new Winner(winnerSplit[0], new Position(winnerSplit[1].length()));
  }

}
