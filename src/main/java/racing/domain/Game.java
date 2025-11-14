package racing.domain;

import java.util.List;

/**
 * 게임 - 자동차 수, 시도 횟수 관리
 *
 */
public class Game {

  private final MovementStrategy strategy;
  private final Participants participants;

  public Game(MovementStrategy strategy, Participants participants) {
    this.strategy = strategy;
    this.participants = participants;
  }

  public void playRound() {
    participants.play(strategy);
  }

  public Participants getParticipants() {
    return this.participants;
  }

  public List<String> getWinners() {
    return participants.getWinnerNames();
  }
}
