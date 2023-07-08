package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class CarsTest {

    @DisplayName("가장 많이 전진한 자동차가 우승한다")
    @Test
    void 자동차_우승자_판별() {
        Cars cars = new Cars(
                new Car(new CarName("pobi"), 3),
                new Car(new CarName("crong"), 4),
                new Car(new CarName("honux"), 5)
        );

        assertThat(cars.getWinners()).isEqualTo(new String[]{"honux"});
    }

    @DisplayName("우승하는 자동차는 여러대일 수 있다")
    @Test
    void 자동차_중복_우승자() {
        Cars cars = new Cars(
                new Car(new CarName("pobi"), 3),
                new Car(new CarName("crong"), 5),
                new Car(new CarName("honux"), 5),
                new Car(new CarName("loopi"), 1)
        );

        assertThat(cars.getWinners()).isEqualTo(new String[]{"crong", "honux"});
    }
}
