package study1.winner.code.service;

import java.util.Random;

public class RaceMove implements MoveStrategy {
  private static final int MAX_NUM = 10;
  private static final int STANDARD_NUM = 4;

  @Override
  public Boolean move() {
    if(new Random().nextInt(MAX_NUM) > STANDARD_NUM) {
      return true;
    }
    return false;
  }
}
