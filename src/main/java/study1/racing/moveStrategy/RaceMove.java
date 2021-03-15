package study1.racing.moveStrategy;

import java.util.Random;

public class RaceMove implements MoveStrategy {
  @Override
  public int move(int maxDistance) {
    return new Random().nextInt(maxDistance + 1);
  }
}
