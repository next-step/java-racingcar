package racingCar;

public class Car {

  private static final Integer NAME_CONSTRAINT = 5;
  private static final String NAME_EXCEPTION = "자동차 이름 길이가 5를 초과했습니다.";

  private final String name;
  private Integer position;

  public Car(String name, Integer position) {
    validate(name);
    this.name = name;
    this.position = position;
  }

  public String getName() {
    return this.name;
  }

  public Integer getPosition() {
    return this.position;
  }

  private void validate(String name) {
    if (name.length() > NAME_CONSTRAINT) {
      throw new OverCarNameLengthException(NAME_EXCEPTION);
    }
  }

  public void move(MovableStrategy movable) {
    this.position += movable.movable() ? 1 : 0;
  }

}
