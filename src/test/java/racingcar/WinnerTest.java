package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.controller.Winner;
import racingcar.model.Car;

public class WinnerTest {

  @ParameterizedTest(name = "[Winner] 우승자인지 판정하는 테스트 - {index}")
  @CsvSource(value = {"4:true", "5:false", "9:false"}, delimiter = ':')
  void isWinnerTest(int maxLocation, boolean expected) {
    Winner win = new Winner();
    Car car = new Car("nana");

    for (int i = 0; i < 4; i++) {
      car.move();
    }
    assertThat(win.isWinner(car, maxLocation)).isEqualTo(expected);
  }
}
