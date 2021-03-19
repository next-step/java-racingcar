package study1.winner.code.service;

import java.util.Random;

public class RaceMove implements MoveStrategy {
  @Override
  public Boolean move() {
    if(new Random().nextInt(10) > 4) {
      return true;
    }
    return false;
  }
}
