package racinggame.model.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingCarFactory {

  private RacingCarFactory() {
  }

  /**
   * carNameArr에 따라 RacingCar 전략을 가진 자동차 인스턴스 생성
   *
   * @param carNameArr : String[], 생성할 자동차 이름
   * @return 생성된 RacingCar 전략을 가진 자동차 인스턴스의 List 반환
   */
  public static List<Car> createRacingCarList(String[] carNameArr) {
    List<Car> racingCarList = new ArrayList<>();

    for (String s : carNameArr) {
      racingCarList.add(new Car(s, new RacingCarMovingStrategy()));
    }

    return racingCarList;
  }
}
