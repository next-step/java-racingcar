package racingCar.service;

import java.util.List;
import racingCar.model.Car;
import racingCar.model.Track;
import racingCar.view.InputTable;

public class CarService {

  private final static Track TRACK = new Track();

  public List<Car> readyCars() {
    TRACK.addCar(InputTable.insertName());
    return TRACK.getCars();
  }

  public Integer gameRound() {
    return InputTable.howManyGame();
  }

  public String winner(List<Car> driver, Car winnerDriver, String winnerDriverName, int index) {
    if (driver.size() == index) {
      return winnerDriverName;
    }
    Car challengerDriver = driver.get(index);
    if (winnerDriver.position() == challengerDriver.position()) {
      winnerDriverName = winnerDriverName.concat(", ").concat(challengerDriver.name());
    }
    if (winnerDriver.position() < challengerDriver.position()) {
      winnerDriver = challengerDriver;
      winnerDriverName = challengerDriver.name();
    }
    return winner(driver, winnerDriver, winnerDriverName, index + 1);
  }
}
