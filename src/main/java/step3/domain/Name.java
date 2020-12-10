package step3.domain;

public class Name {

  private static final int MAX_LENGTH = 5;

  private final String name;

  public Name(String name) {
    valid(name);
    this.name = name;
  }

  public String get() {
    return this.name;
  }

  private static void valid(String input) {
    if (input == null || "".equals(input) || input.length() > MAX_LENGTH) {
      throw new IllegalArgumentException();
    }
  }
}
