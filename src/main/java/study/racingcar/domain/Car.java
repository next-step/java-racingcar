package study.racingcar.domain;

import study.racingcar.error.InvalidCarNameException;
import study.racingcar.util.RandomIntGenerator;
import study.racingcar.util.StringUtils;

public class Car {

  private static final int DEFAULT_BOUND = 10;
  private static final int MINIMUM_MOVE_VALUE = 4;

  private String name;
  private int position;

  public Car(final String name) {
    this(name, 0);
  }

  public Car(final String name, final int position) {
    if(StringUtils.isBlank(name)){
      throw new InvalidCarNameException("자동차 이름은 값이 존재해야 합니다.");
    }
    this.name = name.trim();
    this.position = position;
  }

  public void move() {
    if (isMoving(getRandomInt())) {
      position++;
    }
  }

  private int getRandomInt() {
    return RandomIntGenerator.generate(DEFAULT_BOUND);
  }

  private boolean isMoving(int moveValue) {
    return moveValue >= MINIMUM_MOVE_VALUE;
  }

  public String getName() {
    return name;
  }

  public int getPosition() {
    return position;
  }

  public boolean isWinner(Car competitor) {
    return this.getPosition() >= competitor.getPosition();
  }

  @Override
  public String toString() {
    return "Car{" +
            "name='" + name + '\'' +
            ", distance=" + position +
            '}';
  }
}
