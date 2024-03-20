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

  public Car copy() {
    CarName carName = this.carName.copy();
    Position position = this.position.copy();
    CarMoveStrategy strategy = RandomCarMoveStrategy.copy(this.moveStrategy);
    return new Car(carName, position, strategy);
  }

  public void move(MoveNumberGenerator moveNumberGenerator) {
    if (this.moveStrategy.isMovable(moveNumberGenerator)) {
      this.position.forward();
    }
  }

  // dto 컨버팅 용도로만 사용
  public String getCarName() {
    return carName.getName();
  }

  public Boolean findSamePosition(Car car) {
    return this.position.isSame(car.position);
  }


  // dto 컨버팅, 테스트 코드 용도로만 사용
  public Integer getPosition() {
    return position.getPosition();
  }

  @Override
  public int compareTo(Car o) {
    return this.position.compareTo(o.position);
  }
}
