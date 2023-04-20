package study.domain.racingGame;

public class Car {

  private CarCondition carCondition;
  private int distance;
  private String carName;

  public Car() {
    this.carCondition = new CarCondition();
    this.distance = 0;
  }

  public Car(String carName) {
    this();
    if (!isValidCarName(carName)) {
      throw new IllegalArgumentException("차량 이름은 5글자를 넘길 수 없습니다.");
    }
    this.carName = carName;
  }

  private boolean isValidCarName(String carName) {
    return carName != null && !carName.isEmpty() && carName.length() <= 5;
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

  public String getCarName() {
    return this.carName;
  }
}
