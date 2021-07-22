package step3;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Cars {

  private final RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
  private final List<Car> carList = new ArrayList<>();

  public Cars(int numberOfCars) {
    create(numberOfCars);
  }

  public void move() {
    for (Car car : carList) {
      final int randomNumber = randomNumberGenerator.generate();
      car.move(randomNumber);
    }
  }

  public Result getResult() {
    return new Result(getLocationOfCars());
  }

  public int numberOf() {
    return carList.size();
  }

  private void create(int numberOfCars) {
    IntStream.range(0, numberOfCars)
        .mapToObj(i -> new Car())
        .forEach(carList::add);
  }

  private List<Integer> getLocationOfCars() {
    return carList.stream()
        .map(Car::getLocation)
        .collect(toList());
  }

}
