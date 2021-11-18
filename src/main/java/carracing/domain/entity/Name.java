package carracing.domain.entity;

public class Name {

  private static final int MAX_SIZE = 5;
  private static final String NAME_CREATE_ERROR_MESSAGE = "잘못된 이름 입력입니다.";

  private final String value;

  public Name(String name) {
    validNameCondition(name);
    this.value = name;
  }

  private void validNameCondition(String name) {
    if (name == null || name.isEmpty() || name.length() > MAX_SIZE) {
      throw new IllegalArgumentException(NAME_CREATE_ERROR_MESSAGE);
    }
  }

  public String getName() {
    return value;
  }
}
