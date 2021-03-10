package racingcar.model;

import racingcar.exception.CarNameException;

public class Car {

  private int location;
  private String name;

  public Car(String name) {
    validateName(name);
    this.name = name;
    this.location = 0;
  }

  public void move() {
    location++;
  }

  public int getLocation() {
    return location;
  }

  public String getName() {
    return name;
  }

  public void validateName(String name) {
    isProper(name);
    isEmpty(name);
  }

  private void isProper(String name) {
    if (name.length() > 5) {
      throw new CarNameException("자동차 이름은 5자를 초과할 수 없습니다.");
    }
  }

  private void isEmpty(String name) {
    if ("".equals(name)) {
      throw new CarNameException("자동차 이름을 입력하세요.");
    }
  }
}
