package camp.nextstep.racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarFactory {

  public static final String DELIMITER = ",";

  public static List<Car> of(String carNames) {
    return generate(carNames.split(DELIMITER));
  }

  private static List<Car> generate(String[] carNames) {
    validateCount(carNames.length);
    return Arrays.stream(carNames)
        .map(Car::new)
        .collect(Collectors.toList());
  }

  private static void validateCount(int count) {
    if (count <= 0) {
      throw new IllegalArgumentException("차량 갯수가 없거나 올바르지 않습니다.");
    }
  }

}
