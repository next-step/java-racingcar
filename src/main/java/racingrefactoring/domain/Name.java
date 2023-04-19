package racingrefactoring.domain;

public class Name {
  private final String name;

  private final int MAX_LENGTH = 5;

  protected Name(String name) {
    isValid(name);
    this.name = name;
  }

  private void isValid(String name) {
    if (name.length() > MAX_LENGTH) {
      throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
    }
  }

  public String getName() {
    return name;
  }
}
