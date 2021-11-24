import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCars {

  private List<RacingCar> racingCars;

  public RacingCars(String[] racingCars) {
    int carAmount = racingCars.length;
    this.racingCars = new ArrayList(carAmount);
    createRacingCars(racingCars);
  }

  private void createRacingCars(String[] racingCarNames) {
    for (String racingCar : racingCarNames) {
      this.racingCars.add(new RacingCar(racingCar));
    }
  }

  public void moveEachCars(MoveStrategy strategy) {
    racingCars.forEach(racingCar -> racingCar.move(strategy));
  }

  public List<RacingCar> findWinners() {
    Integer maxProgress = findMaxProgress();
    return findWinners(maxProgress);
  }

  private Integer findMaxProgress() {
    return this.racingCars.stream()
            .mapToInt(RacingCar::getProgress)
            .max()
            .orElse(0);
  }

  private List<RacingCar> findWinners(Integer maxProgress) {
    return this.racingCars.stream()
            .filter(racingCar -> racingCar.equalsProgress(maxProgress))
            .collect(Collectors.toList());
  }


  public List<RacingCar> getRacingCars() {
    return new ArrayList(racingCars);
  }

}
