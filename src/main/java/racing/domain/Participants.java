package racing.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Participants {
  private List<Car> cars;

  public Participants(List<CarName> carNames){
    this.cars = initCars(carNames);
  }

  private List<Car> initCars(List<CarName> carNames){
    List<Car> cars = new ArrayList<>();
    for (CarName name : carNames) {
      cars.add(new Car(name));
    }
    return cars;
  }

  public List<Car> getWinners(){
    Car topCar = findTopCar();
    List<Car> winners = new ArrayList<>();
    Collections.sort(cars);
    for(Car car : cars){
      if(car.hasSamePosition(topCar)){
        winners.add(car);
      }
    }
    return winners;
  }

  private Car findTopCar(){
    return Collections.max(cars, Comparator.comparingInt(Car::getPosition));
  }

  public void play(MovementStrategy strategy) {
    for(Car car : cars){
      car.move(strategy.generate());
    }
  }

  public List<Car> getCars() {
    return this.cars;
  }
}
