package racingcar.step4.domain;

import racingcar.step4.domain.strategy.CarMoveStrategy;
import racingcar.step4.domain.strategy.MoveNumberGenerator;
import racingcar.step4.domain.strategy.RandomCarMoveStrategy;

import java.util.UUID;

public class Car implements Comparable<Car> {

  private final UUID id = UUID.randomUUID();
  private final CarName carName;
  private final Position position;
  private final CarMoveStrategy moveStrategy;

  public Car(String name, CarMoveStrategy carMoveStrategy) {
    this.carName = CarName.naming(name);
    this.position = Position.defaultPosition();
    this.moveStrategy = carMoveStrategy;
  }

  private Car(CarName carName, Position position, CarMoveStrategy moveStrategy) {
    this.carName = carName;
    this.position = position;
    this.moveStrategy = moveStrategy;
  }

  public static Car copy(Car car) {
    CarName carName = CarName.naming(car.getCarName());
    Position position = Position.specificPosition(car.getPosition());
    CarMoveStrategy strategy = RandomCarMoveStrategy.copy(car.getMoveStrategy());
    return new Car(carName, position, strategy);
  }

  public void move(MoveNumberGenerator moveNumberGenerator) {
    if (this.moveStrategy.isMovable(moveNumberGenerator)) {
      this.position.forward();
    }
  }

  public String getCarName() {
    return carName.getName();
  }

  public Integer getPosition() {
    return position.getPosition();
  }

  public CarMoveStrategy getMoveStrategy() {
    return moveStrategy;
  }

  @Override
  public int compareTo(Car o) {
    return this.position.compareTo(o.position);
  }
}
