package racing.dto;

import racing.domain.Participants;
import racing.domain.RoundCount;

/**
 * 레이싱 게임의 현재 진행 상태를 나타내는 결과 객체
 */
public class RacingResult {

  private final RoundCount currentRound;
  private final Participants participants;

  public RacingResult(RoundCount currentRound, Participants participants) {
    this.currentRound = currentRound;
    this.participants = participants;
  }

  public boolean needsResultHeader() {
    return currentRound.isFirstRound();
  }

  public String getCurrentStatus() {
    return participants.toString();
  }
}
