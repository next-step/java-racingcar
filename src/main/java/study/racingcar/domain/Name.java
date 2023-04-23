package study.racingcar.domain;

import study.racingcar.error.InvalidCarNameException;

public class Name {

  private static final int MAXIMUM_NAME_LENGTH = 5;

  private final String name;

  public Name(String name) {
    validationName(name);

    this.name = name.trim();
  }

  private void validationName(String name) {
    if (name == null || name.isBlank()) {
      throw new InvalidCarNameException("이름을 1자 이상 입력해주세요.: ");
    }

    if (name.trim().length() > MAXIMUM_NAME_LENGTH) {
      throw new InvalidCarNameException("이름은 5자를 초과할 수 없습니다.: " + name.trim());
    }
  }

  public String getName() {
    return name;
  }
}
