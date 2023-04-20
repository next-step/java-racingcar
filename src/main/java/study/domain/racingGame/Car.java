package study.domain.racingGame;

public class Car {

  private CarCondition carCondition;
  private int distance;

  public Car() {
    this.carCondition = new CarCondition();
    this.distance = 0;
  }

  public void move(int randomValue) {
    if (!this.carCondition.isMove(randomValue)) {
      return;
    }
    goForward();
  }

  private void goForward() {
    this.distance++;
  }

  public int getTotalDistance() {
    return this.distance;
  }
}
