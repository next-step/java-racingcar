package racingcar;

public class Car {

  public static final String UNIT = "-";
  public static final int THRESHOLD = 4;
  public static final int MAX_NAME_LENGTH = 5;
  public static final String EMPTY_STRING_ERROR_MESSAGE = "비어있는 이름은 유효하지 않은 이름입니다.";
  public static final String MAX_LENGTH_ERROR_MESSAGE = "자동차의 이름은 최대 5자입니다. 입력한 이름: ";

  private int distance;
  private final String name;

  public Car(String name) {
    validateName(name);
    this.name = name;
  }

  private void validateName(String name) {
    validateEmptyName(name);
    validateNameMaxLength(name);
  }

  private void validateEmptyName(String name) {
    if (name == null || name.isEmpty()) {
      throw new IllegalArgumentException(EMPTY_STRING_ERROR_MESSAGE);
    }
  }

  private void validateNameMaxLength(String name) {
    if (name.length() > MAX_NAME_LENGTH) {
      throw new IllegalArgumentException(MAX_LENGTH_ERROR_MESSAGE + name);
    }
  }

  public void move(int randomNumber) {
    if (randomNumber >= THRESHOLD) {
      distance += 1;
    }
  }

  public String showStatus() {
    StringBuilder distanceBuilder = new StringBuilder();

    for (int i = 0; i < distance; i++) {
      distanceBuilder.append(UNIT);
    }

    return distanceBuilder.toString();
  }

  public String getName() {
    return name;
  }
}
