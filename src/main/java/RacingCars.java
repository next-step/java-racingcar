import java.util.ArrayList;
import java.util.List;

public class RacingCars {

  private List<RacingCar> racingCars;

  public RacingCars(int carAmount) {
    this.racingCars = new ArrayList(carAmount);
    createRacingCars(carAmount);
  }

  private void createRacingCars(int carAmount) {
    for (int i = 0; i < carAmount; i++) {
      this.racingCars.add(new RacingCar());
    }
  }

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

  public List<RacingCar> getRacingCars() {
    return new ArrayList(racingCars);
  }

}
