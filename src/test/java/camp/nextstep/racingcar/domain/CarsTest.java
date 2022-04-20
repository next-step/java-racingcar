package camp.nextstep.racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.racingcar.domain.Car;
import camp.nextstep.racingcar.domain.Cars;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class CarsTest {

  @Test
  public void 주어진_자동차_이름으로_자동차들_생성() {
    Cars cars = new Cars(CarFactory.of("pobi,crong,honux"));
    assertThat(cars.size()).isEqualTo(3);
  }

}
