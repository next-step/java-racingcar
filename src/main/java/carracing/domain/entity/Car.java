package carracing.domain.entity;

import java.util.function.BooleanSupplier;

public class Car implements Comparable<Car>{

  private final int ONE = 1;
  private final int MINUS_ONE = -1;

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
    return this.nowStep.getValue() > o.getNowStep() ? MINUS_ONE : ONE;
  }
}
