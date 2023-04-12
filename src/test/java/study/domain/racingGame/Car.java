package study.domain.racingGame;

public class Car {

  private CarCondition carCondition;
  private int distance;
  public Car() {
    carCondition = new CarCondition();
    distance = 0;
  }

  public void move() {
    if (!carCondition.isMove()) {
      return;
    }
    goForward();
  }

  private void goForward() {
    distance++;
  }

  public int findTotalDistance() {
    return distance;
  }
}
