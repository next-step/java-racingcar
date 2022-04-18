package racingCar.model;

public final class CarName {

  private static final int MIN_CAR_NAME_LENGTH = 5;
  private static final String VALID_NULL_NAME = "자동차의 이름은 null이거나 공백일 수 없습니다.";
  private static final String VALID_NULL_MAX_LENGTH = "자동차 이름은 5자를 초과할 수 없습니다.";
  private final String name;

  public CarName(String name) {
    valid(name);
    this.name = name;
  }

  private void valid(String name) {
    if (name == null || name.isBlank()) {
      throw new IllegalArgumentException(VALID_NULL_NAME);
    }
    if (name.length() > MIN_CAR_NAME_LENGTH) {
      throw new IllegalArgumentException(VALID_NULL_MAX_LENGTH);
    }
  }

  @Override
  public String toString() {
    return name;
  }

}
