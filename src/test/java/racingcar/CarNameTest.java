package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.Car;
import racingcar.domain.CarName;
import racingcar.domain.CarPosition;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarNameTest {

    @ParameterizedTest
    @DisplayName("자동차 이름이 유효한 경우 성공적으로 생성되는지 확인")
    @ValueSource(strings = {"yun", "yun2", "yun3"})
    void carNameValid(String name) {
        CarName carName = new CarName(name);
        assertThat(carName.getName()).isEqualTo(name);
    }

    @ParameterizedTest
    @ValueSource(strings = {"longName"})
    @DisplayName("자동차 이름이 5글자 이상인 경우 에러를 반환하는지 확인")
    void carNameThrowsExceptionWhenTooLong(String name) {
        assertThatThrownBy(() -> new Car(new CarName(name), new CarPosition(0)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 5 미만의 글자여야 합니다.");
    }

    @ParameterizedTest
    @DisplayName("자동차 이름이 null이거나 공백일 경우 에러를 반환하는지 확인")
    @ValueSource(strings = {"", "   "})
    void carNameThrowsExceptionWhenNullOrBlank(String name) {
        assertThatThrownBy(() -> new CarName(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 값이 존재해야 합니다.");
    }
}