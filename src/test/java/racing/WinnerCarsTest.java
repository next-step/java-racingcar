package racing;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class WinnerCarsTest {

  @Test
  public void test_add_empty() {

    // Given
    String carNamePobi = "pobi";
    int pobiPosition = 5;
    Car pobiCar = TestCar.of(carNamePobi, pobiPosition);

    WinnerCars winnerCars = new WinnerCars();

    // When
    winnerCars.add(pobiCar);

    // Then
    assertThat(winnerCars.getWinnerNames()).isEqualTo(carNamePobi);
  }

  @Test
  public void test_add_isLoser() {

    // Given
    String carNamePobi = "pobi";
    String carNameCrong = "crong";
    int pobiPosition = 5;
    int crongPosition = 3;
    Car pobiCar = TestCar.of(carNamePobi, pobiPosition);
    Car crongCar = TestCar.of(carNameCrong, crongPosition);

    WinnerCars winnerCars = new WinnerCars();
    winnerCars.add(pobiCar);

    // When
    winnerCars.add(crongCar);

    // Then
    assertThat(winnerCars.getWinnerNames()).isEqualTo(carNamePobi);
  }

  @Test
  public void test_add_isWinner() {

    // Given
    String carNamePobi = "pobi";
    String carNameCrong = "crong";
    int pobiPosition = 3;
    int crongPosition = 5;
    Car pobiCar = TestCar.of(carNamePobi, pobiPosition);
    Car crongCar = TestCar.of(carNameCrong, crongPosition);

    WinnerCars winnerCars = new WinnerCars();
    winnerCars.add(pobiCar);

    // When
    winnerCars.add(crongCar);

    // Then
    assertThat(winnerCars.getWinnerNames()).isEqualTo(carNameCrong);
  }

  @Test
  public void test_add_isEquals() {

    // Given
    String carNamePobi = "pobi";
    String carNameCrong = "crong";
    int pobiPosition = 5;
    int crongPosition = 5;
    Car pobiCar = TestCar.of(carNamePobi, pobiPosition);
    Car crongCar = TestCar.of(carNameCrong, crongPosition);

    WinnerCars winnerCars = new WinnerCars();
    winnerCars.add(pobiCar);

    // When
    winnerCars.add(crongCar);

    // Then
    assertThat(winnerCars.getWinnerNames()).isEqualTo(carNamePobi + ", " + carNameCrong);
  }

  @Test
  public void test_getWinnerNames_one() {

    // Given
    String carNamePobi = "pobi";
    int pobiPosition = 5;

    Car pobiCar =  TestCar.of(carNamePobi, pobiPosition);

    WinnerCars winnerCar = new WinnerCars();
    winnerCar.add(pobiCar);

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
    Car pobiCar = TestCar.of(carNamePobi, pobiPosition);
    Car honuxCar = TestCar.of(carNameHonux, honuxPosition);

    WinnerCars winnerCar = new WinnerCars();
    winnerCar.add(pobiCar);
    winnerCar.add(honuxCar);

    // When
    String winnerNames = winnerCar.getWinnerNames();

    // Then
    assertThat(winnerNames).isEqualTo(carNamePobi + ", " + carNameHonux);
  }
}