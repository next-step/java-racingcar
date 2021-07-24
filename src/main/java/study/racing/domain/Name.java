package study.racing.domain;

import static study.racing.validation.Validation.checkName;

public class Name {

  public static final int LIMIT_LENGTH = 5;

  private String carName;

  public Name(String carName) {
    checkName(carName, LIMIT_LENGTH);
    this.carName = carName;
  }

  public Name() {
  }

  public String getCarName() {
    return carName;
  }

}
