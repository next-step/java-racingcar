package racing;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.Test;

public class RacingGameTest {

  @Test
  public void test_generateCars() {

    // Given
    int carCount = 3;

    // When
    RacingGame racingGame = new RacingGame();
    List<Car> cars = racingGame.generateCars(carCount);

    // Then
    assertThat(cars.size()).isEqualTo(carCount);
  }

  @Test
  public void test_moveCars() {

    // Given
    List<Car> cars = Arrays.asList(new Car(), new Car(), new Car());

    // When
    RacingGame racingGame = new RacingGame();
    racingGame.moveCars(cars);

    // Then
    assertThat(cars.get(0).getPosition()).isBetween(0, 1);
    assertThat(cars.get(1).getPosition()).isBetween(0, 1);
    assertThat(cars.get(2).getPosition()).isBetween(0, 1);
  }
}