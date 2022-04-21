package racingCar.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingCar.service.GameService;

class WinnerTest {

  @Test
  @DisplayName("공동 우승자 구하기")
  void coWinnerTest() {
    List<Car> cars = Arrays.asList(new Car("klom", 2),
                                   new Car("hello", 5),
                                   new Car("bopi", 5));

    List<String> coWinnerNameList = new Winners(cars).findWinnerNameList();
    coWinnerNameList.removeAll(Collections.singletonList(null));
    assertThat(coWinnerNameList).isEqualTo(List.of("hello", "bopi"));
  }


}