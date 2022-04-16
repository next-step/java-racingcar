package racing.domain;

import racing.exception.CarNameUnsuitableException;

public class CarName {

  public static int LENGTH_LIMIT = 5;
  private final String value;

  public CarName(String carName) {
    this.value = carName;
    validName();
  }

  public String getValue() {
    return value;
  }

  private void validName() {
    if (value.isEmpty()) {
      throw new CarNameUnsuitableException("공백 자동차 이름은 허용하지 않습니다.");
    }
    if (value.length() > LENGTH_LIMIT) {
      throw new CarNameUnsuitableException("자동차 이름이 적합하지 않습니다. 이름 : " + value);
    }
  }
}
