import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCars {

  private List<RacingCar> racingCars;

  public RacingCars(String[] racingCars) {
    int carAmount = racingCars.length;
    this.racingCars = new ArrayList(carAmount);
    createRacingCars(racingCars);
  }

  private void createRacingCars(String[] racingCars) {
    for (int i = 0; i < racingCars.length; i++) {
      this.racingCars.add(new RacingCar(racingCars[i]));
    }
  }

  public void moveEachCars(MoveStrategy strategy) {
    racingCars.forEach(racingCar -> racingCar.move(strategy));
  }

  public List<String> findWinnerNames() {
    Integer maxProgress = findMaxProgress();
    return findWinnerNames(maxProgress);
  }

  private Integer findMaxProgress() {
    return this.racingCars.stream()
            .map(RacingCar::getProgress)
            .sorted(Comparator.reverseOrder())
            .findFirst()
            .get();
  }

  private List<String> findWinnerNames(Integer maxProgress) {
    return this.racingCars.stream()
            .filter(racingCar -> racingCar.getProgress() == maxProgress)
            .map(RacingCar::getName)
            .collect(Collectors.toList());
  }


  public List<RacingCar> getRacingCars() {
    return new ArrayList(racingCars);
  }

}
