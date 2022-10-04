package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.strategy.MovingStrategy;

public class RacingRule {

  private static final String DELIMITER = ",";
  private final List<Car> cars;
  private int tryNum;
  private List<ScoreBoards> scoreBoardsList;

  public RacingRule(String names, int tryNum) {
    this.tryNum = tryNum;
    this.cars = buildCars(names);
    this.scoreBoardsList = new ArrayList<>();
  }

  public List<Car> getCars() {
    return cars;
  }

  private List<Car> buildCars(String names) {
    return Arrays.asList(names.split(DELIMITER))
        .stream()
        .map(name -> new Car(name))
        .collect(Collectors.toList());
  }

  public void play(MovingStrategy strategy) {
    for (int i = 0; i < tryNum; i++) {
      cycleCars(strategy);
      saveScoreBoards();
    }
  }

  private void cycleCars(MovingStrategy strategy) {
    this.cars.forEach(car -> car.move(strategy));
  }

  private void saveScoreBoards() {
    List<ScoreBoard> scoreBoards = this.cars.stream()
        .map(car -> car.scoreBoard())
        .collect(Collectors.toList());
    this.scoreBoardsList.add(new ScoreBoards(scoreBoards));
  }

  public List<ScoreBoards> getScoreBoardsList() {
    return this.scoreBoardsList;
  }

  public List<String> findWinner() {
    int index = this.scoreBoardsList.size() - 1;
    ScoreBoards scoreBoards = this.scoreBoardsList.get(index);
    return scoreBoards.findFirst();

  }

}
