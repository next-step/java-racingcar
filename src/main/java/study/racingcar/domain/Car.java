package study.racingcar.domain;

import study.racingcar.error.InvalidCarNameException;

public class Car {

  private static final int MAXIMUM_NAME_LENGTH = 5;
  private static final int MINIMUM_MOVE_VALUE = 4;

  private final String name;
  private Position position;

  public Car(final String name) {
    this(name, new Position());
  }

  public Car(final String name, final int position) {
    this(name, new Position(position));
  }

  public Car(final String name, final Position position) {
    validationName(name);

    this.name = name.trim();
    this.position = position;
  }

  private void validationName(String name) {
    if (name == null || name.isBlank()) {
      throw new InvalidCarNameException("이름을 1자 이상 입력해주세요.: ");
    }

    if (name.trim().length() > MAXIMUM_NAME_LENGTH) {
      throw new InvalidCarNameException("이름은 5자를 초과할 수 없습니다.: " + name.trim());
    }
  }

  public void move(RandomInt randomInt) {
    if (randomInt.isMoving(MINIMUM_MOVE_VALUE)) {
      this.position.increase();
    }
  }

  public boolean isSamePosition(Position otherPosition) {
    return this.position.equals(otherPosition);
  }

  public Position getMaxPosition(Position otherPosition) {
    return this.position.getMaxPosition(otherPosition);
  }

  public String getName() {
    return this.name;
  }

  public String getFootPrint(String footPrint) {
    return this.position.getFootPrint(footPrint);
  }
}
