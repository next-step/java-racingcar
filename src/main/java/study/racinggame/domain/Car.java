package study.racinggame.domain;

public class Car {

  private int distance;

  public Car() {
    this.distance = 0;
  }

  public int distance() {
    return distance;
  }

  public void forward(GameStrategy racingStrategy) {
    if (racingStrategy.movable()) {
      distance++;
    }
  }

  public void printDistance() {
    String printedDistance = "";

    for (int i = 0; i < distance; i++) {
      printedDistance += "-";
    }

    System.out.println(printedDistance);
  }
}
