package camp.nextstep.racingcar.domain;

import java.util.Objects;

public class CarName {

  private final String name;

  public CarName(String name) {
    if (name == null || name.length() > 5) {
      throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
    }
    this.name = name;
  }

  public String getName() {
    return name;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CarName carName = (CarName) o;
    return Objects.equals(name, carName.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name);
  }

  @Override
  public String toString() {
    return "CarName{" +
        "name='" + name + '\'' +
        '}';
  }
}
