package racingCar.game;

import java.util.ArrayList;
import java.util.List;

public class GameResult {
  List<String> winners;
  List<String> roundResults;

  public GameResult(){
    this.winners = new ArrayList<>();
    this.roundResults = new ArrayList<>();
  }

  public List<String> getWinners() {
    return winners;
  }

  public List<String> getRoundResults() {
    return roundResults;
  }

  public void addRoundResult(String result){
    roundResults.add(result);
  }

  public void setWinners(List<String> winners) {
    this.winners = winners;
  }
}
