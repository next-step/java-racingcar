package study.racingcar.domain;

import study.racingcar.factory.RandomIntFactory;

public class Car {

  private static final int MINIMUM_MOVE_VALUE = 4;

  private Name name;
  private Position position;

  public Car(final String name) {
    this(new Name(name), new Position());
  }

  public Car(final String name, final int position) {
    this(new Name(name), new Position(position));
  }

  public Car(final Name name, final Position position) {
    this.name = name;
    this.position = position;
  }

  public void move(RandomIntFactory randomIntFactory) {
    RandomInt randomInt = randomIntFactory.createRandomInt();
    if (randomInt.isGreaterThan(MINIMUM_MOVE_VALUE)) {
      position = position.increase();
    }
  }

  public boolean isSamePosition(Position otherPosition) {
    return this.position.equals(otherPosition);
  }

  public Position getMaxPosition(Position otherPosition) {
    return this.position.getMaxPosition(otherPosition);
  }

  public String getName() {
    return this.name.getName();
  }

  public int getPosition() {
    return this.position.getPosition();
  }
}
