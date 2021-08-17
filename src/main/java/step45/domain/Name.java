package step45.domain;

import step45.utils.StringUtils;

public class Name {

  private static final int MAX_LENGTH = 5;
  private final String name;

  public Name(String name) {
    checkName(name);
    this.name = name;
  }

  public String getName() {
    return name;
  }

  private void checkName(String name) {
    if (StringUtils.isBlank(name) || name.length() > MAX_LENGTH) {
      throw new IllegalArgumentException("자동차의 이름은 1글자 이상 " + MAX_LENGTH + "글자 이하로 입력해야합니다.");
    }
  }
}
