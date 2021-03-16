package racingcar.domain;

import java.util.Objects;
import racingcar.util.UserInputValidator;

public class CarName {

  private final String name;

  public CarName(String name) {
    UserInputValidator.carNameValidation(name);
    this.name = name;
  }

  public String toString() {
    return name;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof CarName)) {
      return false;
    }
    CarName carName = (CarName) o;
    return Objects.equals(name, carName.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name);
  }
}
