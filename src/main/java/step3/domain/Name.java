package step3.domain;

public class Name {

  public static final int MAX = 5;

  private final String name;

  public Name(String name) {
    validate(name);
    this.name = name;
  }

  private void validate(String name) {
    if (name.length() > MAX) {
      throw new IllegalArgumentException("자동차 이름은 " + MAX + "자를 초과할 수 없다");
    }
  }

  public String getName() {
    return name;
  }
}
