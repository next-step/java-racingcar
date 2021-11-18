package carracing.domain.entity;

import java.util.function.BooleanSupplier;

public class Car implements Comparable<Car>{

  private final Name name;
  private final Step nowStep;

  public Car(Name name) {
    this.name = name;
    this.nowStep = new Step();
  }

  public Car(Name name, Step step) {
    this.name = name;
    this.nowStep = step;
  }

  public void move(BooleanSupplier isMovable) {
    if(isMovable.getAsBoolean()) {
      nowStep.plus();
    }
  }

  public String getName() {
    return name.getName();
  }

  public int getNowStep() {
    return this.nowStep.getValue();
  }

  @Override
  public int compareTo(Car o) {
    return Integer.compare(o.getNowStep(), this.nowStep.getValue());
  }

  public boolean equalStep(Car o) {
    return this.nowStep.isEqualTo(o.nowStep);
  }
}
