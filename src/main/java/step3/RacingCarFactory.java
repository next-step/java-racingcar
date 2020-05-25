package step3;

import java.util.ArrayList;
import java.util.List;

public class RacingCarFactory {
  private RacingCarFactory() {}
  
  /**
   * numberOfCars 에 따라 자동차 인스턴스 생성
   * @param numberOfCars : int 생성할 자동차 개수
   * @return 생성된 자동차 인스턴스의 List 반환
   */
  public static List<Car> createRacingCarList(int numberOfCars) {
    List<Car> racingCarList = new ArrayList<>();

    for (int i = 0; i < numberOfCars; i++) {
      racingCarList.add(new RacingCar());
    }

    return racingCarList;
  }
}
