package racingcar.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.model.wrapper.CarName;

import java.util.List;

import static racingcar.model.enums.Status.FORWARD;
import static racingcar.model.enums.Status.STOP;
import static racingcar.model.fixture.CarsFixture.*;

public class WinnerTest {

    @Test
    void 우승자_생성() {
        // given
        Car car1 = new Car(carName1, List.of(FORWARD, STOP, FORWARD, FORWARD));
        Car car2 = new Car(carName2, List.of(FORWARD, FORWARD, FORWARD, FORWARD));
        Car car3 = new Car(carName3, List.of(FORWARD, FORWARD, FORWARD, FORWARD));
        Cars cars =new Cars(List.of(car1, car2, car3));


        // when
        Assertions.assertThatNoException().isThrownBy(() -> {
            // then
            Winner winner = new Winner(cars);
        });
    }

    @Test
    void 가장_많이_이동한_자동차들을_구한다() {
        // given
        Car car1 = new Car(carName1, List.of(FORWARD, STOP, FORWARD, FORWARD));
        Car car2 = new Car(carName2, List.of(FORWARD, FORWARD, FORWARD, FORWARD));
        Car car3 = new Car(carName3, List.of(FORWARD, FORWARD, FORWARD, FORWARD));
        Cars cars = new Cars(List.of(car1, car2, car3));
        List<CarName> expected = List.of(car2.carName(), car3.carName());

        // when
        List<CarName> actual = new Winner(cars).result();

        // then
        Assertions.assertThat(actual).isEqualTo(expected);
    }
}
