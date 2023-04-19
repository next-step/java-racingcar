package racing.domain;


import racingrefactoring.util.RandomNumberGenerator;

public class RandomMoveStrategy implements MoveStrategy {

  @Override
  public boolean isMovable() {
    int randomNumber = RandomNumberGenerator.generateNumber();
    return CarMoveCondition.isMove(randomNumber);
  }
}
