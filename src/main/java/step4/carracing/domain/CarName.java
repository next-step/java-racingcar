package step4.carracing.domain;

public class CarName {
  private static final int MAX_NAME_LENGTH = 5;
  private final String value;

  public CarName(String value) {
    validate(value);
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  private void validate(String name) {
    if (name == null || name.isEmpty()) {
      throw new IllegalArgumentException("이름은 null이거나 빈 문자열일 수 없습니다.");
    }

    if (name.length() > MAX_NAME_LENGTH) {
      throw new IllegalArgumentException("이름은 5자 이하여야 합니다.");
    }
  }

}
