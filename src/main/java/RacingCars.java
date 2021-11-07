import java.util.ArrayList;
import java.util.List;

public class RacingCars {

  private List<RacingCar> racingCarList;

  public RacingCars(int carAmount) {
    this.racingCarList = new ArrayList(carAmount);
    for (int i = 0; i < carAmount; i++) {
      this.racingCarList.add(new RacingCar());
    }
  }

  public void moveEachCars(MoveStrategy strategy) {
    racingCarList.forEach(racingCar -> racingCar.move(strategy));
  }

  public List<RacingCar> getRacingCarList() {
    return this.racingCarList;
  }

}
