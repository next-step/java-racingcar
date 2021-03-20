package study1.winner.code.service;

import java.util.Objects;

public class Car {
  private static final int INIT_DISTANCE = 0;
  private static final int INCREASE_DISTANCE = 1;
  
  private final Name name;
  private int distance;


  public Car(Name name, int distance) {
    this.name = name;
    this.distance = distance;
  }

  public Car(String name) {
    this(new Name(name), INIT_DISTANCE);
  }

  public Car(String name, int distance) {
    this(new Name(name), distance);
  }

  public Car(Car car) {
    this(car.name, car.distance);
  }

  public Car move(MoveStrategy moveStrategy) {
    if(moveStrategy.move()) {
      distance += INCREASE_DISTANCE;
    }
    return new Car(new Name(name.name()), distance);
  }

  public String driver() {
    return name.name();
  }

  public int distance() {
    return distance;
  }

  public boolean isWinner(int maxDistance) {
    if(distance == maxDistance) {
      return true;
    }
    return false;
  }

  @Override
    public boolean equals(Object o) {
        if (o == this) {
          return true;
        }
        if (!(o instanceof Car)) {
          return false;
        }
        Car car = (Car) o;
        return Objects.equals(name, car.name) && distance == car.distance;
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, distance);
  }

}
