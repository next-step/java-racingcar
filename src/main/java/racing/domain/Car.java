package racing.domain;

public class Car {

  private static final int MOVE_THRESHOLD = 4;
  private static final int MAX_NAME_LENGTH = 5;

  private int position;

  private String name;

  public Car(String name) {
    validateName(name);
    this.name = name;
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
    if (randomNumber < 0 || randomNumber > 9) {
      throw new IllegalArgumentException("랜덤 값은 0에서 9 사이여야 합니다.");
    }

    if (randomNumber >= MOVE_THRESHOLD) {
      position++;
    }
  }
}
