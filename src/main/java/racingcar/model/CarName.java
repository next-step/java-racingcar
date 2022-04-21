package racingcar.model;

import racingcar.commons.Constant;
import racingcar.exception.InputValueException;

public class CarName {

  private static final int MAXIMUM_LENGTH_OF_NAME = 5;
  private final String value;

  public CarName(String name) {
    if (name.length() > MAXIMUM_LENGTH_OF_NAME) {
      throw new InputValueException(Constant.CAR_NAME_MAXIMUM_LENGTH_EXCEEDED_ERR_MSG);
    }

    this.value = name;
  }

  public String getValue() {
    return value;
  }
}
