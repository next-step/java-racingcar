package study1.winner.code.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Race {
  private static final int START_NUM = 0;
  private final int round;
  private Cars cars;

  public Race(int round, Cars cars) {
    this.round = round;
    this.cars = cars;
  }

  public Race(int round, String participants) {
    this(
      round, 
      new Cars(Arrays.asList(participants.split(","))
        .stream()
        .map((name) -> new Car(name))
        .collect(Collectors.toList()))
    );
  }

  public List<Cars> start() {
    return IntStream
      .range(START_NUM, round)
      .boxed()
      .map((i) -> cars.move())
      .map((cars) -> roundCheck(cars))
      .collect(Collectors.toList());
  }

  public Cars roundCheck(Cars cars) {
    this.cars = new Cars(cars);
    return cars;
  }

  public List<String> winners() {
    return cars.winners();
  }
}
