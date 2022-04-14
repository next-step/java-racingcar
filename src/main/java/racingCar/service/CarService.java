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
    System.out.println("테스트");
    return InputTable.howManyGame();
  }
}
