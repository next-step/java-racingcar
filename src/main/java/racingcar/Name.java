package racingcar;

public class Name {

  private static final int MAX_LENGTH = 5;
  private final String value;

  public Name(String value) {
    validate(value);
    this.value = value;
  }

  private void validate(String value) {
    if (value == null) {
      throw new IllegalArgumentException("이름은 null일 수 없습니다.");
    }
    if (value.isEmpty()) {
      throw new IllegalArgumentException("이름은 빈 문자열일 수 없습니다.");
    }
    if (value.length() > MAX_LENGTH) {
      throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
    }
  }

  @Override
  public String toString() {
    return value;
  }
}
