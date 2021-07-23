package study.racing.domain;

import study.racing.validation.Validation;

public class Name {

  private String carName;

  public Name(String carName) {
    Validation.checkName(carName);
      this.carName = carName;
  }

  public Name() {
  }

  public String getCarName() {
    return carName;
  }

}
