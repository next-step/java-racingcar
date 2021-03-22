package step5.model;

import java.util.Objects;

public class Name {
  private final String name;
  private final int MAXIMUM_LENGTH = 5;

  public Name(String name) {
    if (name == null || name.trim().isEmpty() || name.length() > MAXIMUM_LENGTH) {
      throw new IllegalArgumentException("입력된 차량의 이름을 확인하세요. 1~5자 허용입니다. 이름: " + name);
    }
    this.name = name;
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
