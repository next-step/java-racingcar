package camp.nextstep.racingcar.domain;

public class Car {

  private final String name;
  private int position;

  public Car(String name) {
    validateName(name);

    this.name = name;
    this.position = 0;
  }

  private void validateName(String name) {
    if (name == null || name.length() > 5) {
      new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
    }
  }

  public void move(MoveCondition condition) {
    if (!condition.isSatisfied()) {
      return;
    }
    this.position++;
  }

  public int getPosition() {
    return position;
  }

  public String getName() {
    return name;
  }
}
