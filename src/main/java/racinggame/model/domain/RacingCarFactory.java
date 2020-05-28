package racinggame.model.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

  /**
   * List&lt;Car&gt; 를 List&lt;CarDTO&gt;로 변환
   *
   * @param racingCarList : List&lt;Car&gt; 원본 리스트
   * @return 변환된 리스트
   */
  public static List<CarDTO> createRacingCarDTOList(List<Car> racingCarList) {
    List<CarDTO> racingCarDTOList = racingCarList.stream()
        .map(CarDTO::newInstace)
        .collect(Collectors.toList());

    for (int i = 0, endpoint = racingCarList.size(); i < endpoint; i++) {
      racingCarList.set(i, Car.newInstance(racingCarList.get(i)));
    }

    return racingCarDTOList;
  }
}
