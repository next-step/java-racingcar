package Racing;

import static org.assertj.core.api.Assertions.assertThat;

import Racing.car.CarList;
import Racing.type.RacingNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RaceTest {

  @ParameterizedTest
  @DisplayName("Race")
  @CsvSource(value = {"1|1", "1|2", "2|1", "3|5", "4|6", "6|7"}, delimiter = '|')
  void testRace(int countOfCarInput, int countOfStageInput) {
    // given
    RacingNumber countOfCar = new RacingNumber(countOfCarInput);
    RacingNumber countOfStage = new RacingNumber(countOfStageInput);

    // when
    CarList cars = new Race(countOfCar, countOfStage).run();
    // then
    assertThat(cars.size()).isEqualTo(countOfCar);
  }

}