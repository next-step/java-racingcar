package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.strategy.MovingStrategy;

public class RacingRule {

  private static final String DELIMITER = ",";
  private final Cars cars;
  private int tryNum;
  private List<ScoreBoards> scoreBoardsList;

  public RacingRule(String names, int tryNum) {
    this.tryNum = tryNum;
    this.cars = new Cars(buildCars(names));
    this.scoreBoardsList = new ArrayList<>();
  }

  private List<Car> buildCars(String names) {
    return Arrays.stream(names.split(DELIMITER))
        .map(Car::new)
        .collect(Collectors.toList());
  }

  public void play(MovingStrategy strategy) {
    for (int i = 0; i < tryNum; i++) {
      cycleCars(strategy);
      saveScoreBoards();
    }
  }

  private void cycleCars(MovingStrategy strategy) {
    for (Car car : cars.getCars()) {
      if (strategy.isMoveAble()) {
        car.move();
      }
    }
  }

  private void saveScoreBoards() {
    List<ScoreBoard> scoreBoards = this.cars.getCars().stream()
        .map(car -> new ScoreBoard(car.getName(), car.getCarPosition()))
        .collect(Collectors.toList());
    this.scoreBoardsList.add(new ScoreBoards(scoreBoards));
  }

  public List<String> findWinner() {
    int index = this.scoreBoardsList.size() - 1;
    ScoreBoards scoreBoards = this.scoreBoardsList.get(index);
    return scoreBoards.findFirst();

  }

  public List<Car> getCars() {
    return cars.getCars();
  }

  public List<ScoreBoards> getScoreBoardsList() {
    return this.scoreBoardsList;
  }

}
