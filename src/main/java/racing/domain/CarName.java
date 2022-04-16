package racing.domain;

import racing.domain.strategy.NameValidationStrategy;
import racing.exception.CarNameUnsuitableException;

public class CarName {

  private final String value;
  private final NameValidationStrategy nameValidationStrategy;

  public CarName(String carName, NameValidationStrategy nameValidationStrategy) {
    this.value = carName;
    this.nameValidationStrategy = nameValidationStrategy;
    validCheck();
  }

  public String getValue() {
    return value;
  }

  private void validCheck() {
    if (!nameValidationStrategy.isValid(value)) {
      throw new CarNameUnsuitableException(value);
    }
  }
}
