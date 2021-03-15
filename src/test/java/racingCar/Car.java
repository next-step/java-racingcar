package racingCar;

public class Car {
  private static final Integer NAME_CONSTRAINT = 5;
  private static final String NAME_EXCEPTION = "자동차 이름 길이가 5를 초과했습니다.";

  private int distance;
  private final String name;

  public Car(String name) {
    validate(name);
    this.name = name;
  }

  private void validate(String name) {
    if (name.length() >= NAME_CONSTRAINT) {
      throw new OverCarNameLengthException(NAME_EXCEPTION);
    }
  }

  public void move(MovableStrategy movable) {
    this.distance += movable.movable() ? 1 : 0;
  }

  public int getDistance() {
    return this.distance;
  }

}
