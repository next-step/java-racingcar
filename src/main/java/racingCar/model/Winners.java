package racingCar.model;

import java.util.ArrayList;
import java.util.List;
import racingCar.util.StringUtils;

public class Winners {

  public int findWinnerPosition(List<Car> cars) {
    int maxPosition = 0;
    for (Car car : cars) {
      maxPosition = car.changeMaxPosition(maxPosition);
    }
    return maxPosition;
  }

  public List<String> findCoWinnerNameList(List<Car> cars, int winnerPosition) {
    List<String> carNames = new ArrayList<>();
    for (Car car : cars) {
      carNames.add(car.equalsMaxPosition(winnerPosition));
    }
    return carNames;
  }

}
