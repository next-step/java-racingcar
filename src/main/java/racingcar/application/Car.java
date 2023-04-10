package racingcar.application;

public class Car {
  private static final int GO_BOUNDARY = 3;

  private final Accelerator accelerator;
  private int location = 1;

  public Car(Accelerator accelerator) {
    this.accelerator = accelerator;
  }

  public void go() {
    int value = this.accelerator.accelerate();

    if (value > GO_BOUNDARY) {
      location += 1;
    }
  }

  public int location() {
    return this.location;
  }
}
