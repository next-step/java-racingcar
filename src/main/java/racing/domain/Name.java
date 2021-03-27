package racing.domain;

import racing.validation.DomainValidation;

import java.util.Objects;

public class Name {
  private final static int RACING_CAR_NAME_LENGTH = 5;
  private final static String RACING_CAR_EXCEPTION_MESSAGE = "Car name length is exceed";

  private final String name;

  private Name(String name) {
    checkExceedStringLength(name);
    this.name = name;
  }

  public static Name create(String name) {
    return new Name(name);
  }

  public String getName() {
    return name;
  }

  private void checkExceedStringLength(String name) {
    int nameLength = name.length();
    DomainValidation.checkExceedStringLength(nameLength, RACING_CAR_NAME_LENGTH, RACING_CAR_EXCEPTION_MESSAGE);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Name name1 = (Name) o;
    return Objects.equals(name, name1.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name);
  }

  @Override
  public String toString() {
    return name;
  }

}
