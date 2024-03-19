package racingcar.step4.domain;

import java.util.Objects;

public class CarName {

  public static final int NAME_MINIMUM_LENGTH = 1;
  public static final int NAME_MAXIMUM_LENGTH = 5;
  public static final String EXCEEDED_MAXIMUM_LENGTH = "자동차 이름은 %s자를 초과할 수 없습니다. input: %s, inputLength: %s";
  public static final String MUST_EXCEED_CERTAIN_LENGTH = "자동차 이름은 최소 %s자 이상이어야 합니다. input: %s";

  private final String name;

  private CarName(String name) {
    validate(name);
    this.name = name;
  }

  public static CarName naming(String name) {
    return new CarName(name);
  }

  public String getName() {
    return name;
  }

  private static void validate(String name) {

    if (Objects.isNull(name) || name.isBlank()) {
      throw new IllegalArgumentException(String.format(MUST_EXCEED_CERTAIN_LENGTH, NAME_MINIMUM_LENGTH, name));
    }

    if (name.length() > NAME_MAXIMUM_LENGTH) {
      throw new IllegalArgumentException(String.format(EXCEEDED_MAXIMUM_LENGTH, NAME_MAXIMUM_LENGTH, name, name.length()));
    }
  }
}
