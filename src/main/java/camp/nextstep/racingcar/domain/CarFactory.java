package camp.nextstep.racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class CarFactory {

  public static List<Car> of(int count) {
    validateCount(count);
    return generate(count);
  }

  private static void validateCount(int count) {
    if (count <= 0) {
      throw new IllegalArgumentException("차량 갯수가 없거나 올바르지 않습니다.");
    }
  }

  private static List<Car> generate(int count) {
    List<Car> racingCars = new ArrayList<>(count);
    for (int i = 0; i < count; i++) {
      racingCars.add(new Car());
    }
    return racingCars;
  }

}
