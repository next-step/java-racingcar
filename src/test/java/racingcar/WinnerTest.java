package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.controller.Winner;
import racingcar.model.Car;

public class WinnerTest {

  @Test
  @DisplayName("[Winner] 우승자를 구하기 위한 가장 큰 위치를 구하는 테스트")
  void getMaxPositionTest() {
    Winner win = new Winner();
    List<Car> cars = Arrays.asList(new Car("crong", 2), new Car("pobi", 3), new Car("conan", 5));
    assertThat(win.getMaxPosition(cars)).isEqualTo(5);
  }

  @ParameterizedTest(name = "[Winner] 우승자인지 판정하는 테스트 - {index}")
  @CsvSource(value = {"4:true", "5:false", "9:false"}, delimiter = ':')
  void isWinnerTest(int maxLocation, boolean expected) {
    Winner win = new Winner();
    Car car = new Car("nana", 4);
    assertThat(win.isWinner(car.getPosition(), maxLocation)).isEqualTo(expected);
  }
}
