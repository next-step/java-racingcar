package racingcar.domain;

public class RandomMovingStrategy implements MovingStrategy {

  private static final int MOVEABLE_CRITERIA = 4;

  @Override
    public boolean moveable(int generatedRandomNumber) {
      return generatedRandomNumber >= MOVEABLE_CRITERIA;
    }
}
