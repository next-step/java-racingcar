package racing.domain;

import java.util.List;

/**
 * 게임 - 자동차 수, 시도 횟수 관리
 *
 */
public class Game {

  private final MovementStrategy strategy;
  private final Participants participants;
  private final int tryCnt;

  public Game(MovementStrategy strategy, Participants participants, int tryCnt) {
    this.strategy = strategy;
    this.participants = participants;
    this.tryCnt = tryCnt;
  }

  public void play() {
    participants.play(strategy);
  }

  public Participants getParticipants() {
    return this.participants;
  }

  public int getTryCnt() {
    return this.tryCnt;
  }

  public List<Car> getWinners() {
    return participants.getWinners();
  }
}
