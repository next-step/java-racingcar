package step3;

import java.util.ArrayList;
import java.util.List;

public class RacingCarFactory {
  private RacingCarFactory() {}

  /**
   * numberOfCars 에 따라 RacingCar 전략을 가진 자동차 인스턴스 생성
   * 
   * @param numberOfCars : int 생성할 자동차 개수
   * @return 생성된 RacingCar 전략을 가진 자동차 인스턴스의 List 반환
   */
  public static List<Car> createRacingCarList(int numberOfCars) {
    List<Car> racingCarList = new ArrayList<>();

    for (int i = 0; i < numberOfCars; i++) {
      racingCarList.add(new Car("", new RacingCarMovingStrategy()));
    }

    return racingCarList;
  }

  /**
   * carNameArr에 따라 RacingCar 전략을 가진 자동차 인스턴스 생성
   * 
   * @param carNameArr : String[], 생성할 자동차 이름
   * @return 생성된 RacingCar 전략을 가진 자동차 인스턴스의 List 반환
   */
  public static List<Car> createRacingCarList(String[] carNameArr) {
    List<Car> racingCarList = new ArrayList<>();

    for (int i = 0; i < carNameArr.length; i++) {
      racingCarList.add(new Car(carNameArr[i], new RacingCarMovingStrategy()));
    }

    return racingCarList;
  }
}
