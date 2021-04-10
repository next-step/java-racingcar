package study.step3;


import java.util.List;

public class CarRace {

  private final int carNumber;

  private final int times;

  public CarRace(int carNumber, int times) {
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
