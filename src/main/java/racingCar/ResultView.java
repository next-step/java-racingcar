package racingCar;

import java.util.List;

public class ResultView {

  public void printAllCarsStatus(List<RacingCar> racingCarList) {
    racingCarList.forEach(car -> System.out.println(presentCarStatus(car)));
    System.out.println();
  }

  public String presentCarStatus(RacingCar racingCar) {
    StringBuffer stringBuffer = new StringBuffer();

    for (int i = 0; i < racingCar.getMoveCount(); i++) {
      stringBuffer.append("-");
    }

    return stringBuffer.toString();
  }
}
