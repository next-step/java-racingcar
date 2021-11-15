package carracing.domain.entity;

import java.util.function.BooleanSupplier;

public class Car implements Comparable<Car>{

  private final String name;
  private final Step nowStep;

  public Car(String name) {
    this.name = name;
    this.nowStep = new Step();
  }

  public void move(BooleanSupplier isMovable) {
    if(isMovable.getAsBoolean()) {
      nowStep.plus();
    }
  }

  public String getName() {
    return name;
  }

  public int getNowStep() {
    return this.nowStep.getValue();
  }

  @Override
  public int compareTo(Car o) {
    return Integer.compare(o.getNowStep(), this.nowStep.getValue());
  }
}
