package racingcar;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import static java.util.stream.Collectors.joining;

public class RacingGameTest {


  private RacingGame racingGame;

  @BeforeEach
  void setUp() {
    this.racingGame = new RacingGame();
  }

  @Test
  @DisplayName("console에 '--' 가 표시된다")
  void test() {

    String currentPosition = IntStream.rangeClosed(0, 1)
            .mapToObj(pos -> "-")
            .collect(joining());

    System.out.println(currentPosition);
  }

  @Test
  @DisplayName("총 3라운드 진행, 1라운드에 '--' 3줄, 2라운드에 '---' 3줄, 3라운드에 '----' 3줄 표시된다")
  void printRacingStatus() {

    int rounds = 3;
    List<Car> cars = Arrays.asList(
            new Car("car1"),
            new Car("car2"),
            new Car("car3"));

    RacingGame.printRacingStatus(rounds, cars);

  }

  @Test
  @DisplayName("console에 '--' 3줄이 표시된다")
  void drive() {
    List<Car> cars = Arrays.asList(
            new Car("car1"),
            new Car("car2"),
            new Car("car3"));

    RacingGame.drive(cars);
  }
}
