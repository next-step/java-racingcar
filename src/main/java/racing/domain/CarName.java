package racing.domain;

import racing.domain.strategy.NameValidationStrategy;
import racing.exception.CarNameUnsuitableException;

public class CarName {

  private final String carName;
  private final NameValidationStrategy nameValidationStrategy;

  public CarName(String carName, NameValidationStrategy nameValidationStrategy) {
    this.carName = carName;
    this.nameValidationStrategy = nameValidationStrategy;
    validCheck();
  }

  public String getCarName() {
    return carName;
  }

  private void validCheck() {
    if (!nameValidationStrategy.isValid(carName)) {
      throw new CarNameUnsuitableException(carName);
    }
  }
}
