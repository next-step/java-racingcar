package racingcar.application;

public class Car {

  private final Accelerator accelerator;
  private int location = 1;

  public Car(Accelerator accelerator) {
    this.accelerator = accelerator;
  }

  public void go() {
    int value = this.accelerator.accelerate();

    if (value > 3) {
      location += 1;
    }
  }

  public int location() {
    return this.location;
  }
}
