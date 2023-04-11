package study.racinggame.domain;

public class Car {

  private static final String PRINTED_DISTANCE = "-";
  private int distance;

  public Car() {
    this(0);
  }

  public Car(int distance) {
    this.distance = distance;
  }

  public int distance() {
    return distance;
  }

  public void forward(GameStrategy racingStrategy) {
    if (racingStrategy.movable()) {
      distance++;
    }
  }

  public String printedDistance() {
    return PRINTED_DISTANCE.repeat(distance);
  }
}
