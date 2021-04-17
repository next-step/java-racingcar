package study.step3.domain;

public class GameRound {

  private int round;

  public GameRound(int times) {
    this.round = times;
  }

  public boolean isEnd() {
    if (this.round > 0) {
      this.round--;
      return false;
    }

    return true;
  }

}
