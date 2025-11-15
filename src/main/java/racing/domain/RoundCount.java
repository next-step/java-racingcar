package racing.domain;

import racing.exception.ErrorMessage;
import racing.exception.RacingException;

public class RoundCount {

  private int cnt;

  public RoundCount(int cnt) {
    if (cnt < 0) {
      throw new RacingException(RoundCountMessage.INVALID_ROUND);
    }
    this.cnt = cnt;
  }

  public int getCount() {
    return cnt;
  }

  enum RoundCountMessage implements ErrorMessage {
    INVALID_ROUND("1번 이상 수행되어야 합니다");

    private String message;

    RoundCountMessage(String message) {
      this.message = message;
    }

    public String getMessage() {
      return message;
    }
  }
}
