package racing;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.Test;

public class WinnerCarsTest {

  @Test
  public void test_add_empty() {

    // Given
    String carNamePobi = "pobi";
    int pobiPosition = 5;
    Car pobiCar = TestCar.ofWithTrueRandomGenerator(carNamePobi, pobiPosition);

    TestWinnerCars winnerCars = new TestWinnerCars();

    // When
    winnerCars.add(pobiCar);

    // Then
    assertThat(winnerCars.getWinnerCars().size()).isEqualTo(1);

    Car winnerCar = winnerCars.getWinnerCars().get(0);
    assertThat(winnerCar.getName()).isEqualTo(carNamePobi);
    assertThat(winnerCar.getPosition()).isEqualTo(pobiPosition);
  }

  @Test
  public void test_add_isLoser() {

    // Given
    String carNamePobi = "pobi";
    String carNameCrong = "crong";
    int pobiPosition = 5;
    int crongPosition = 3;
    Car pobiCar = TestCar.ofWithTrueRandomGenerator(carNamePobi, pobiPosition);
    Car crongCar = TestCar.ofWithTrueRandomGenerator(carNameCrong, crongPosition);

    TestWinnerCars winnerCars = new TestWinnerCars(Collections.singletonList(pobiCar));

    // When
    winnerCars.add(crongCar);

    // Then
    assertThat(winnerCars.getWinnerCars().size()).isEqualTo(1);

    Car winnerCar = winnerCars.getWinnerCars().get(0);
    assertThat(winnerCar.getName()).isEqualTo(carNamePobi);
    assertThat(winnerCar.getPosition()).isEqualTo(pobiPosition);
  }

  @Test
  public void test_add_isWinner() {

    // Given
    String carNamePobi = "pobi";
    String carNameCrong = "crong";
    int pobiPosition = 3;
    int crongPosition = 5;
    Car pobiCar = TestCar.ofWithTrueRandomGenerator(carNamePobi, pobiPosition);
    Car crongCar = TestCar.ofWithTrueRandomGenerator(carNameCrong, crongPosition);

    TestWinnerCars winnerCars = new TestWinnerCars(Collections.singletonList(pobiCar));

    // When
    winnerCars.add(crongCar);

    // Then
    assertThat(winnerCars.getWinnerCars().size()).isEqualTo(1);

    Car winnerCar = winnerCars.getWinnerCars().get(0);
    assertThat(winnerCar.getName()).isEqualTo(carNameCrong);
    assertThat(winnerCar.getPosition()).isEqualTo(crongPosition);
  }

  @Test
  public void test_add_isEquals() {

    // Given
    String carNamePobi = "pobi";
    String carNameCrong = "crong";
    int pobiPosition = 5;
    int crongPosition = 5;
    Car pobiCar = TestCar.ofWithTrueRandomGenerator(carNamePobi, pobiPosition);
    Car crongCar = TestCar.ofWithTrueRandomGenerator(carNameCrong, crongPosition);

    List<Car> cars = new ArrayList<>();
    cars.add(pobiCar);

    TestWinnerCars winnerCars = new TestWinnerCars(cars);

    // When
    winnerCars.add(crongCar);

    // Then
    assertThat(winnerCars.getWinnerCars().size()).isEqualTo(2);
  }

  @Test
  public void test_getWinnerNames_one() {

    // Given
    String carNamePobi = "pobi";

    int pobiPosition = 5;
    List<Car> cars = Collections.singletonList(
        TestCar.ofWithTrueRandomGenerator(carNamePobi, pobiPosition)
    );

    WinnerCars winnerCar = new TestWinnerCars(cars);

    // When
    String winnerNames = winnerCar.getWinnerNames();

    // Then
    assertThat(winnerNames).isEqualTo(carNamePobi);
  }

  @Test
  public void test_getWinnerNames_multi() {

    // Given
    String carNamePobi = "pobi";
    String carNameHonux = "honux";

    int pobiPosition = 5;
    int honuxPosition = 5;
    List<Car> cars = Arrays.asList(
        TestCar.ofWithTrueRandomGenerator(carNamePobi, pobiPosition),
        TestCar.ofWithTrueRandomGenerator(carNameHonux, honuxPosition)
    );

    WinnerCars winnerCar = new TestWinnerCars(cars);

    // When
    String winnerNames = winnerCar.getWinnerNames();

    // Then
    assertThat(winnerNames).isEqualTo(carNamePobi + ", " + carNameHonux);
  }
}