import java.util.ArrayList;
import java.util.List;

public class RacingCars {

  private List<RacingCar> racingCars;

  public RacingCars(int carAmount) {
    this.racingCars = new ArrayList(carAmount);
    for (int i = 0; i < carAmount; i++) {
      this.racingCars.add(new RacingCar());
    }
  }

  public void moveEachCars(MoveStrategy strategy) {
    racingCars.forEach(racingCar -> racingCar.move(strategy));
  }

  public List<RacingCar> getRacingCarList() {
    return new ArrayList(racingCars);
  }

}
