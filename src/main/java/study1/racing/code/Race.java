package study1.racing.code;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Race {
  private final int START_NUM = 0;

  private final List<Car> cars;
  private final int round;

  public Race(int participant, int round) {
    this.cars = Stream.generate(Car::new).limit(participant).collect(Collectors.toList());
    this.round = round;
  }

  public List<RaceRound> start() {
    return IntStream
      .range(START_NUM, round)
      .boxed()
      .map((i) -> roundCheck())
      .collect(Collectors.toList());
  }

  public RaceRound roundCheck() {
    cars.stream()
      .forEach((car) -> car.move());
    return new RaceRound(
      cars.stream()
        .map((car) -> new Car(car))
        .collect(Collectors.toList())
    );
  }
}
