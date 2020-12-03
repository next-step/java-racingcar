package step3;

import step3.domain.Cars;

public class RacingGame {

  public void start(int numberOfCar, int gameCount) {
    Cars carList = new Cars(numberOfCar);
    System.out.println("실행결과");
    for (int i = 0; i < gameCount; i++) {
      carList.race();
    }
  }

}
