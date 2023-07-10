package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.car.Cars;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatNoException;

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
    @ValueSource(strings = {"pobi,croong,honux", "pobi,,honux", ""})
    void 자동차_입력_검증_실패_1(String carNames) {
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> new Cars(carNames))
                .withMessageMatching("자동차 이름이 유효하지 않습니다");
    }

    @DisplayName("자동차 이름이 없을 경우 예외가 발생한다")
    @Test
    void 자동차_입력_검증_실패_2() {
        String carNames = ",,,,";
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> new Cars(carNames))
                .withMessageMatching("자동차 이름이 존재하지 않습니다");
    }
}
