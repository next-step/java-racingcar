package racing.domain;

import racing.domain.strategy.MoveStrategy;

public class NamedCar extends Car {

  private final CarName carName;

  public NamedCar(CarName carName, MoveStrategy moveStrategy) {
    super(moveStrategy);
    this.carName = carName;
  }

  public String getCarName() {
    return carName.getValue();
  }

  public static NamedCar newInstance(String name, MoveStrategy moveStrategy) {
    return new NamedCar(new CarName(name), moveStrategy);
  }
}
