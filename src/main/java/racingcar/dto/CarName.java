package racingcar.dto;

public class CarName {

  private final int MIN_LENGTH = 1;
  private final int MAX_LENGTH = 5;

  private String name;

  public CarName(String name) {
    this.name = throwIfIsNotValidated(name);
  }

  public String name() {
    return this.name;
  }

  private String throwIfIsNotValidated(String name) {
    if (name.length() < MIN_LENGTH) {
      throw new IllegalArgumentException(String.format("자동차 이름은 %d 글자를 넘어야 합니다", MIN_LENGTH));
    }

    if (name.length() > MAX_LENGTH) {
      throw new IllegalArgumentException(String.format("자동차 이름은 %d 글자를 넘을 수 없습니다", MAX_LENGTH));
    }

    return name;
  }
}
