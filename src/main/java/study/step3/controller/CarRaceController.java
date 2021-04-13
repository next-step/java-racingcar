package study.step3.controller;


import java.util.List;
import study.step3.domain.CarFactory;
import study.step3.validator.RandomNumber;
import study.step3.domain.Car;
import study.step3.view.InputView;
import study.step3.view.ResultView;

public class CarRaceController {

  InputView inputView;

  public CarRaceController(InputView inputView) {
    this.inputView = inputView;
  }

  public List<Car> start() {
    this.inputView.validateInputValue();

    List<Car> cars = CarFactory.makeCar(inputView.getCarNumber());

    ResultView resultView = new ResultView();

    resultView.printRacingEndMessage();

    for (int i = 0; i < this.inputView.getTimes(); i++) {
      cars.forEach(car -> car.move(RandomNumber.generator()));

      resultView.printPosition(cars);
    }


    return cars;
  }


}
