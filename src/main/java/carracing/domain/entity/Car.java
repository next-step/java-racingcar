package carracing.domain.entity;

import java.util.function.BooleanSupplier;

public class Car {

  private final Step nowStep;

  public Car() {
    this.nowStep = new Step();
  }

  public void move(BooleanSupplier isMovable) {
    if(isMovable.getAsBoolean()) {
      nowStep.plus();
    }
  }

  public int getNowStep() {
    return this.nowStep.getValue();
  }

}
