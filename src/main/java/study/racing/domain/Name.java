package study.racing.domain;

import static study.racing.validation.Validation.checkName;

import java.util.Objects;

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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Name name = (Name) o;
    return Objects.equals(getCarName(), name.getCarName());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getCarName());
  }
}
