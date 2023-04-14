package racing.race;

import racing.util.RandomUtil;

public class Car {

  private int moveDistance;

  public void move() {
    int random = RandomUtil.getRandomValue();
    if (random >= 4) {
      moveDistance++;
    }
  }

  public int moveDistance() {
    return moveDistance;
  }

}
