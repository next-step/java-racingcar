package racingGame;


public class DummyScoreGenerator implements ScoreGenerator {

  private int index;

  public DummyScoreGenerator() {
    this.index = 0;
  }

  @Override
  public int generateScore() {
    index += 1;
    index %= 2;
    return index;
  }
}
