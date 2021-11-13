package carracing.domain.entity;

import carracing.domain.dto.RacingData;

import java.util.function.Supplier;

public class Car {

  private Step nowStep;

  public Car() {
    this.nowStep = new Step();
  }

  public RacingData move(Supplier<Boolean> isMoved) {
    if(isMoved.get()) {
      nowStep.plus();
    }
    return new RacingData(getNowStep());
  }

  public int getNowStep() {
    return this.nowStep.getValue();
  }

}
