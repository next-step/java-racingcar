package step3;

import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.stream.IntStream;

public class Cars {

  private final RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
  private List<Car> cars;

  public Cars(int numberOfCars) {
    create(numberOfCars);
  }

  public void move() {
    for (Car car : cars) {
      final int randomNumber = randomNumberGenerator.generate();
      car.move(randomNumber);
    }
  }

  public Result getResult() {
    return new Result(getLocationOfCars());
  }

  public int numberOf() {
    return cars.size();
  }

  private void create(int numberOfCars) {
    cars = IntStream.range(0, numberOfCars)
        .mapToObj(i -> new Car())
        .collect(toList());
  }

  private List<Integer> getLocationOfCars() {
    return cars.stream()
        .map(Car::getLocation)
        .collect(toList());
  }

}
