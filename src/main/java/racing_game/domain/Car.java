package racing_game.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import racing_game.core.Positive;

public class Car {

  private int currentTime;
  private List<Positive> distance; // time x distance - 시간 대별(회차) 거리
  private Random random;

  private Car(Random random) {
    this.currentTime = 0;
    this.distance = new ArrayList<>();
    this.distance.add(Positive.zero());
    this.random = (random == null) ? new Random() : random;
  }

  public static Car create() {
    return new Car(null);
  }

  public static Car create(Random random) {
    return new Car(random);
  }

  public void move() {
    Positive currentDistance = distance.get(currentTime++);
    distance.add(Positive.copy(currentDistance));
    if (isGoAvailable()) {
      distance.get(currentTime).addOne();
    }
  }

  private boolean isGoAvailable() {
    return random.nextInt(10) >= 4;
  }

  public int getDistance(int targetTime) {
    return distance.get(targetTime).toInteger();
  }

  public int getCurrentDistance() {
    return distance.get(currentTime).toInteger();
  }

  @Override
  public String toString() {
    return "Car{"
        + "currentTime="
        + currentTime
        + ", distance="
        + distance
        + ", random="
        + random
        + '}';
  }
}
