package camp.nextstep.racingcar.domain;

public class DefaultMoveCondition implements MoveCondition {

  public static final int CONDITIONAL_VALUE = 4;

  private NumberGenerator numberGenerator;

  public DefaultMoveCondition(NumberGenerator numberGenerator) {
    this.numberGenerator = numberGenerator;
  }

  @Override
  public boolean isSatisfied() {
    int randomNumber = numberGenerator.generate();
    if (randomNumber >= CONDITIONAL_VALUE) {
      return true;
    }
    return false;
  }

}
