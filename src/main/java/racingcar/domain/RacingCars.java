package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingCars {
  private List<RacingCar> racingCars;

  public RacingCars(int numberOfCars) {
    this.racingCars = new ArrayList<>();

    for (int i = 0; i < numberOfCars; i++) {
      this.racingCars.add(new RacingCar());
    }
  }

  // 자동차들 객체 가져오기
  public List<RacingCar> statusOfRacingCars() {
    return racingCars;
  }

}
