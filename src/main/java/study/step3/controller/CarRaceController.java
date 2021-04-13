package study.step3.controller;


import java.util.List;
import study.step3.domain.CarFactory;
import study.step3.validator.RandomNumber;
import study.step3.domain.Car;
import study.step3.view.ResultView;

public class CarRaceController {

  private final int carNumber;

  private final int times;

  public CarRaceController(int carNumber, int times) {
    this.carNumber = carNumber;
    this.times = times;
  }

  public List<Car> start() {
    List<Car> cars = CarFactory.makeCar(carNumber);

    ResultView resultView = new ResultView();

    resultView.printRacingEndMessage();

    for (int i = 0; i < this.times; i++) {
      cars.forEach(car -> car.move(RandomNumber.generator()));

      resultView.printPosition(cars);
    }


    return cars;
  }


}
