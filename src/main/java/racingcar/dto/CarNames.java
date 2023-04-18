package racingcar.dto;

import java.util.Arrays;
import java.util.List;

public class CarNames {

  private final List<String> carNames;
  private int pointer = 0;

  public CarNames(String carNameBundle) {
    this.carNames = split(carNameBundle);
  }

  public List<String> carNames() {
    return this.carNames;
  }

  private List<String> split(String input) {
    try {
      return Arrays.asList(input.split(","));
    } catch(NumberFormatException e)  {
      System.out.println("숫자를 입력해 주세요");
      throw new IllegalArgumentException();
    }
  }
}
