package racing;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import racing.view.InputView;
import racing.view.TestInputView;

public class RacingGameTest {

  @Test
  public void test_game() {

    // Given
    int carCount = 3;
    int moveCount = 5;
    TestInputView testInputView = new TestInputView(carCount, moveCount);
    TestRandomGenerator randomGenerator = new TestRandomGenerator(true);

    // When
    RacingGame racingGame = new RacingGame(testInputView, randomGenerator);
    List<Car> cars = racingGame.game();

    // Then
    assertThat(cars.get(0).getPosition()).isEqualTo(5);
    assertThat(cars.get(1).getPosition()).isEqualTo(5);
    assertThat(cars.get(2).getPosition()).isEqualTo(5);

  }

  @Test
  public void test_startRacing() {

    // Given
    int moveCount = 5;
    TestRandomGenerator randomGenerator = new TestRandomGenerator(true);
    List<Car> cars = Arrays.asList(
        new Car(randomGenerator),
        new Car(randomGenerator),
        new Car(randomGenerator)
    );

    // When
    RacingGame racingGame = new RacingGame(new InputView());
    racingGame.startRacing(cars, moveCount);

    // Then
    assertThat(cars.get(0).getPosition()).isEqualTo(5);
    assertThat(cars.get(1).getPosition()).isEqualTo(5);
    assertThat(cars.get(2).getPosition()).isEqualTo(5);

  }

  @Test
  public void test_generateCars() {

    // Given
    int carCount = 3;

    // When
    RacingGame racingGame = new RacingGame(new InputView());
    List<Car> cars = racingGame.generateCars(carCount);

    // Then
    assertThat(cars.size()).isEqualTo(carCount);
  }

  @Test
  public void test_moveCars() {

    // Given
    List<Car> cars = Arrays.asList(
        new Car(new TestRandomGenerator(true)),
        new Car(new TestRandomGenerator(false)),
        new Car(new TestRandomGenerator(true))
    );

    // When
    RacingGame racingGame = new RacingGame(new InputView());
    racingGame.moveCars(cars);

    // Then
    assertThat(cars.get(0).getPosition()).isEqualTo(1);
    assertThat(cars.get(1).getPosition()).isEqualTo(0);
    assertThat(cars.get(2).getPosition()).isEqualTo(1);
  }
}