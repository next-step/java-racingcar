package racingcar.dto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarNames {

  private final List<CarName> carNames;
  private final int ONE = 1;

  public CarNames(String carNameBundle) {
    this.carNames = split(carNameBundle);
  }

  public List<CarName> carNames() {
    return this.carNames;
  }

  private List<CarName> split(String input) {
      return Arrays.stream(emptyIfThrow(input.split(",")))
          .map(nameString -> new CarName(nameString))
          .collect(Collectors.toList());
  }

  private String[] emptyIfThrow(String[] input) {
    if (input.length < ONE) {
      throw new IllegalArgumentException("빈 값은 들어올 수 없습니다");
    }

    return input;
  }
}