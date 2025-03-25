package racingcar;

import java.util.ArrayList;

public class Winner {

  private final Names carNames;
  private final Cars result;

  public Winner(Names carNames, Result result) {
    this.carNames = carNames;
    this.result = result.getRoundResult(result.size() - 1);
  }

  public ArrayList<Car> getWinners() {
    ArrayList<Car> winners = new ArrayList<>();
    findWinners(winners);
    return winners;
  }

  private void findWinners(ArrayList<Car> winners) {
    int maxScore = getMaxScore();
    for (int i = 0; i < carNames.size(); i++) {
      if (result.at(i).isWinner(maxScore)) {
        winners.add(result.at(i));
      }
    }
  }

  private int getMaxScore() {
    int maxScore = 0;
    for (int i = 0; i < carNames.size(); i++) {
      if (result.at(i).hasHigherScore(maxScore)) {
        maxScore = result.at(i).getScore();
      }
    }
    return maxScore;
  }
}
