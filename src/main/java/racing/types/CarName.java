package racing.types;

import racing.property.CarRacingGameProperty;

public class CarName {

  private static final int MAZ_CAR_NAME_LEN = 5;

  private final String name;

  public CarName() {
    this.name = CarRacingGameProperty.CAR_DEFAULT_NAME;
  }

  public static CarName valueOf(String carName) {
    return new CarName(carName);
  }

  private CarName(String carName) {
    if (carName == null || carName.isEmpty()) {
      throw new IllegalArgumentException("차 이름은 비어있을 수 없습니다.");
    }
    if (carName.length() > MAZ_CAR_NAME_LEN) {
      throw new IllegalArgumentException("차 이름은 5글자를 초과할 수 없습니다.");
    }
    this.name = carName;
  }

  public String getName() {
    return name;
  }
}
