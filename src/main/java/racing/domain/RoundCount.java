package racing.domain;

import java.util.Objects;
import racing.exception.ErrorMessage;
import racing.exception.RacingException;

public class RoundCount {

  private int cnt;

  public RoundCount(int cnt) {
    if (cnt <= 0) {
      throw new RacingException(RoundCountMessage.INVALID_ROUND);
    }
    this.cnt = cnt;
  }

  public void doRace() {
    this.cnt -= 1;
  }

  public boolean canRace() {
    return this.cnt > 0;
  }

  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RoundCount that = (RoundCount) o;
    return cnt == that.cnt;
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(cnt);
  }

  static class RoundCountMessage extends ErrorMessage {

    public static final RoundCountMessage INVALID_ROUND =
        new RoundCountMessage("1번 이상 수행되어야 합니다");

    private RoundCountMessage(String message) {
      super(message);
    }
  }
}
