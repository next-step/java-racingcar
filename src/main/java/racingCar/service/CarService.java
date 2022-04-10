package racingCar.service;

import java.util.List;
import racingCar.model.Car;
import racingCar.model.Track;
import racingCar.view.InputTable;

public class CarService {

  private final static Track TRACK = new Track();

  public List<Car> readyCars() {
    TRACK.addCar(InputTable.howManyCar());
    return TRACK.getCars();
  }

  public Integer gameRound() {
    return InputTable.howManyGame();
  }
}
