package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class CarsTest {

    @DisplayName("유효한 자동차 이름일 경우 예외가 발생하지 않는다")
    @ParameterizedTest
    @ValueSource(strings = {"pobi,crong,honux", "a", " a "})
    void 자동차_입력_검증_성공(String carNames) {
        assertThatNoException()
                .isThrownBy(() -> new Cars(carNames));
    }

    @DisplayName("유효하지 않은 자동차 이름일 경우 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(strings = {"pobi,croong,honux", "pobi,,honux", "", ",,,,"})
    void 자동차_입력_검증_실패(String carNames) {
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> new Cars(carNames))
                .withMessageMatching(Cars.INVALID_CAR_NAME_EXCEPTION_MESSAGE);
    }

    @DisplayName("가장 많이 전진한 자동차가 우승한다")
    @Test
    void 자동차_우승자_판별() {
        Cars cars = new Cars(
                new Car("pobi", 3),
                new Car("crong", 4),
                new Car("honux", 5)
        );

        assertThat(cars.getWinners()).isEqualTo(new String[]{"honux"});
    }

    @DisplayName("우승하는 자동차는 여러대일 수 있다")
    @Test
    void 자동차_중복_우승자() {
        Cars cars = new Cars(
                new Car("pobi", 3),
                new Car("crong", 5),
                new Car("honux", 5),
                new Car("loopi", 1)
        );

        assertThat(cars.getWinners()).isEqualTo(new String[]{"crong", "honux"});
    }
}
