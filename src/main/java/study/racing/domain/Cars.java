package study.racing.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import study.racing.generator.Generator;
import study.racing.generator.RandomGenerator;

public class Cars {

  public static final String SPLIT_MARK = ",";

  private final List<Car> cars = new ArrayList<>();

  private Generator generator = new RandomGenerator();

  public Cars(int count) {
    IntStream.range(0, count).mapToObj(i -> readyToCar()).forEach(cars::add);
  }

  public Cars(String carName) {
    Arrays.asList(carName.split(SPLIT_MARK)).forEach(name -> cars.add(readyToCar(name)));
  }

  public int getMaxMoveDistance() {
    int max = 0;
    for (Car car : cars) {
      max = getMaximumDistance(max, car);
    }

    return max;
  }

  private int getMaximumDistance(int max, Car car) {
    if(car.isMaxDistance(car.getDistance(), max)){
      return car.maxDistance(car);
    }
    return max;
  }

  private Car readyToCar(String carName) {
    return Car.createCar(carName);
  }

  private Car readyToCar() {
    return Car.createCar();
  }

  public List<Car> getCars() {
    return cars;
  }

  public void moveTheCar() {
    cars.forEach(car -> car.moveTheCar(generator.generateNewNumber()));
  }

  public List<Car> getWinners() {
    return cars.stream()
        .filter(car -> car.isWinner(getMaxMoveDistance()))
        .collect(Collectors.toList());
  }

}
