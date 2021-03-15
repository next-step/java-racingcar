package study1.racing;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Race {
  private final List<Car> cars;
  private final int round;

  public Race(int participant, int round) {
    this.cars = Stream.generate(Car::new).limit(participant).collect(Collectors.toList());
    this.round = round;
  }

  public void run () {
    IntStream
      .range(0, round)
      .forEach((i) -> checkDistance());
  }
  
  public void checkDistance() {
    cars.stream()
      .map((car) -> car.move())
      .forEach((distance) -> this.recordDistance(distance));
    System.out.print("\n");
  }

  public void recordDistance(int distance) {
    ResultView.print(distance);
  }
}
