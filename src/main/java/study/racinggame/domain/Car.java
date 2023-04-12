package study.racinggame.domain;

public class Car {

  private static final String PRINTED_DISTANCE = "-";
  private final String name;
  private int distance;

  public Car(String name) {
    this(name,0);
  }

  public Car(String name, int distance) {
    this.name = name;
    this.distance = distance;
  }

  public String name() {
    return name;
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
    return name + " : " + PRINTED_DISTANCE.repeat(distance);
  }
}
