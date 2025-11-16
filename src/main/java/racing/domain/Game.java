package racing.domain;

import java.util.List;
import racing.dto.RacingResult;

/**
 * 게임 라운드 진행
 */
public class Game {

  private final MovementStrategy strategy;
  private final Participants participants;
  private final RoundCount roundCount;

  public Game(String names, int cnt){
    this(new Participants(names), new RoundCount(cnt));
  }

  public Game(Participants participants, RoundCount roundCount){
    this(new MovementStrategy(), participants, roundCount);
  }

  public Game(MovementStrategy strategy, Participants participants, RoundCount roundCount) {
    this.strategy = strategy;
    this.participants = participants;
    this.roundCount = roundCount;
  }

  public void playRound() {
    participants.play(strategy);
    roundCount.doRace();
  }

  public RacingResult getRacingResult() {
    return new RacingResult(this.roundCount, this.participants);
  }

  public List<String> getWinners() {
    return participants.getWinnerNames();
  }

  public boolean canRace() {
    return roundCount.canRace();
  }
}
