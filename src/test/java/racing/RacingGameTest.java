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
    String carNamePobi = "pobi";
    String carNameCrong = "crong";
    String carNameHonux = "honux";

    String carNames = carNamePobi + "," + carNameCrong + "," + carNameHonux;
    int moveCount = 5;
    TestInputView testInputView = new TestInputView(carNames, moveCount);
    TestRandomGenerator randomGenerator = new TestRandomGenerator(true);

    // When
    RacingGame racingGame = new RacingGame(testInputView, randomGenerator);
    List<Car> cars = racingGame.game();

    // Then
    assertThat(cars.get(0).getName()).isEqualTo(carNamePobi);
    assertThat(cars.get(0).getPosition()).isEqualTo(5);
    assertThat(cars.get(1).getName()).isEqualTo(carNameCrong);
    assertThat(cars.get(1).getPosition()).isEqualTo(5);
    assertThat(cars.get(2).getName()).isEqualTo(carNameHonux);
    assertThat(cars.get(2).getPosition()).isEqualTo(5);
  }

  @Test
  public void test_winner_one() {

    // Given
    String carNamePobi = "pobi";
    String carNameCrong = "crong";
    String carNameHonux = "honux";

    int pobiPosition = 2;
    int crongPosition = 5;
    int honuxPosition = 3;
    TestRandomGenerator randomGenerator = new TestRandomGenerator(true);
    List<Car> cars = Arrays.asList(
        new TestCar(randomGenerator, carNamePobi, pobiPosition),
        new TestCar(randomGenerator, carNameCrong, crongPosition),
        new TestCar(randomGenerator, carNameHonux, honuxPosition)
    );

    // When
    RacingGame racingGame = new RacingGame(new InputView());
    List<Car> winnerCars = racingGame.winner(cars);

    // Then
    assertThat(winnerCars.size()).isEqualTo(1);
    assertThat(winnerCars.get(0).getName()).isEqualTo(carNameCrong);
    assertThat(winnerCars.get(0).getPosition()).isEqualTo(crongPosition);
  }

  @Test
  public void test_winner_multi() {

    // Given
    String carNamePobi = "pobi";
    String carNameCrong = "crong";
    String carNameHonux = "honux";

    int pobiPosition = 5;
    int crongPosition = 3;
    int honuxPosition = 5;
    TestRandomGenerator randomGenerator = new TestRandomGenerator(true);
    List<Car> cars = Arrays.asList(
        new TestCar(randomGenerator, carNamePobi, pobiPosition),
        new TestCar(randomGenerator, carNameCrong, crongPosition),
        new TestCar(randomGenerator, carNameHonux, honuxPosition)
    );

    // When
    RacingGame racingGame = new RacingGame(new InputView());
    List<Car> winnerCars = racingGame.winner(cars);

    // Then
    assertThat(winnerCars.size()).isEqualTo(2);
    assertThat(winnerCars.get(0).getName()).isEqualTo(carNamePobi);
    assertThat(winnerCars.get(0).getPosition()).isEqualTo(pobiPosition);
    assertThat(winnerCars.get(1).getName()).isEqualTo(carNameHonux);
    assertThat(winnerCars.get(1).getPosition()).isEqualTo(honuxPosition);
  }

  @Test
  public void test_startRacing() {

    // Given
    String carNamePobi = "pobi";
    String carNameCrong = "crong";
    String carNameHonux = "honux";

    int moveCount = 5;
    TestRandomGenerator randomGenerator = new TestRandomGenerator(true);
    List<Car> cars = Arrays.asList(
        new Car(randomGenerator, carNamePobi),
        new Car(randomGenerator, carNameCrong),
        new Car(randomGenerator, carNameHonux)
    );

    // When
    RacingGame racingGame = new RacingGame(new InputView());
    racingGame.startRacing(cars, moveCount);

    // Then
    assertThat(cars.get(0).getName()).isEqualTo(carNamePobi);
    assertThat(cars.get(0).getPosition()).isEqualTo(5);
    assertThat(cars.get(1).getName()).isEqualTo(carNameCrong);
    assertThat(cars.get(1).getPosition()).isEqualTo(5);
    assertThat(cars.get(2).getName()).isEqualTo(carNameHonux);
    assertThat(cars.get(2).getPosition()).isEqualTo(5);

  }

  @Test
  public void test_generateCars() {

    // Given
    String carNamePobi = "pobi";
    String carNameCrong = "crong";
    String carNameHonux = "honux";

    String carNames = carNamePobi + "," + carNameCrong + "," + carNameHonux;

    // When
    RacingGame racingGame = new RacingGame(new InputView());
    List<Car> cars = racingGame.generateCars(carNames);

    // Then
    assertThat(cars.size()).isEqualTo(3);
    assertThat(cars.get(0).getName()).isEqualTo(carNamePobi);
    assertThat(cars.get(1).getName()).isEqualTo(carNameCrong);
    assertThat(cars.get(2).getName()).isEqualTo(carNameHonux);
  }

  @Test
  public void test_moveCars() {

    // Given
    String carNamePobi = "pobi";
    String carNameCrong = "crong";
    String carNameHonux = "honux";

    List<Car> cars = Arrays.asList(
        new Car(new TestRandomGenerator(true), carNamePobi),
        new Car(new TestRandomGenerator(false), carNameCrong),
        new Car(new TestRandomGenerator(true), carNameHonux)
    );

    // When
    RacingGame racingGame = new RacingGame(new InputView());
    racingGame.moveCars(cars);

    // Then
    assertThat(cars.get(0).getName()).isEqualTo(carNamePobi);
    assertThat(cars.get(0).getPosition()).isEqualTo(1);
    assertThat(cars.get(1).getName()).isEqualTo(carNameCrong);
    assertThat(cars.get(1).getPosition()).isEqualTo(0);
    assertThat(cars.get(2).getName()).isEqualTo(carNameHonux);
    assertThat(cars.get(2).getPosition()).isEqualTo(1);
  }

}