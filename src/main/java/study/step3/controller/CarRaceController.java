package study.step3.controller;


import java.util.List;
import study.step3.domain.CarFactory;
import study.step3.domain.Cars;
import study.step3.domain.Car;
import study.step3.domain.GameRound;
import study.step3.view.ResultView;

public class CarRaceController {

  public CarRaceController() {
  }

  public List<Car> start(int carNumber, int times) {
    Cars cars = CarFactory.makeCar(carNumber);

    ResultView resultView = new ResultView();

    resultView.printRacingEndMessage();

    List<Car> carList = cars.getCars();

    GameRound gameRound = new GameRound(times);

    while(!gameRound.isEnd()) {
      cars.move();
      resultView.printPosition(cars);
    }

    return carList;
  }

}
