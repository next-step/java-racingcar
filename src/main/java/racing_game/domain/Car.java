package racing_game.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import racing_game.core.Positive;

public class Car {

  private int now;
  private final List<Positive> distance; // time x distance - 시간 대별(회차) 거리
  private final Random random;

  private Car(Random random) {
    this.now = 0;
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
    nextTime();
    if (canMove()) {
      distance.get(now).addOne();
    }
  }

  private void nextTime() {
    Positive current = distance.get(now++);
    distance.add(Positive.copy(current));
  }

  private boolean canMove() {
    return random.nextInt(10) >= 4;
  }

  public int getDistance(int time) {
    if (time >= distance.size()) {
      throw new IllegalArgumentException("time is over than current car dist");
    }
    return distance.get(time).toInt();
  }

  public int getCurrentDistance() {
    return distance.get(now).toInt();
  }

  @Override
  public String toString() {
    return "Car{" + "currentTime=" + now + ", distance=" + distance + ", random=" + random + '}';
  }
}
