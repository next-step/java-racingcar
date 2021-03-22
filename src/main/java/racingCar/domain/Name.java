package racingCar.domain;

import java.util.Objects;

public class Name {

  private static final Integer NAME_CONSTRAINT = 5;
  private static final String NAME_EXCEPTION = "자동차 이름 길이가 5를 초과했습니다.";

  private final String name;

  public Name(String name) {
    if (name.length() > NAME_CONSTRAINT) {
      throw new OverCarNameLengthException(NAME_EXCEPTION);
    }
    this.name = name;
  }

  public String getName() {
    return this.name;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Name name1 = (Name) o;
    return Objects.equals(name, name1.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name);
  }
}
