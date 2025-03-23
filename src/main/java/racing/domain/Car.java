package racing.domain;

public class Car {

  private static final int MOVE_THRESHOLD = 4;
  private static final int MAX_NAME_LENGTH = 5;
  private static final int MIN_RANDOM_VALUE = 0;
  private static final int MAX_RANDOM_VALUE = 9;

  private int position;

  private String name;

  public Car(String name) {
    this(name, 0);
  }

  public Car(String name, int position) {
    validateName(name);
    this.name = name;
    this.position = position;
  }

  private void validateName(String name) {
    if (name.length() > MAX_NAME_LENGTH) {
      throw new IllegalArgumentException("자동차 이름은 " + MAX_NAME_LENGTH + "자를 초과할 수 없습니다.");
    }
  }

  public int getPosition() {
    return position;
  }

  public String getName() {
    return name;
  }

  public void driveOrStop(int randomNumber) {
    if (randomNumber < MIN_RANDOM_VALUE || randomNumber > MAX_RANDOM_VALUE) {
      throw new IllegalArgumentException("랜덤 값은 0에서 9 사이여야 합니다.");
    }

    if (randomNumber >= MOVE_THRESHOLD) {
      position++;
    }
  }
}
