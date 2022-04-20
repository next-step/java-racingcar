package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import racing.domain.CarName;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class CarNameTest {

    @DisplayName("자동차 이름의 객체 생성하면 CarName의 인스턴스를 반환한다")
    @ParameterizedTest
    @ValueSource(strings = {"carA", "carB", "car🫣"})
    void createCarName(String name) {
        assertThat(new CarName(name)).isInstanceOf(CarName.class);
    }

    @DisplayName("자동차 이름이 null 이거나 빈값이면 예외를 던진다")
    @ParameterizedTest
    @NullAndEmptySource
    void createNullAndEmptyCarNameThrowsException(String name) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new CarName(name))
                .withMessage("자동차 이름은 빈 값이거나 null일 수 없습니다");
    }

    @DisplayName("자동차 이름이 5글자를 초과하면 예외를 던진다")
    @ParameterizedTest
    @ValueSource(strings = {"carABC", "carABCD", "car❌❌❌"})
    void createCarNameThrowsException(String name) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new CarName(name))
                .withMessage("자동차 이름은 5글자를 초과하지 않아야합니다");
    }

    @DisplayName("자동차의 이름은 string 타입을 반환한다")
    @ParameterizedTest
    @ValueSource(strings = {"carA", "carB", "car🫣"})
    void getNameTest(String name) {
        assertThat(new CarName(name).getName()).isInstanceOf(String.class).isEqualTo(name);
    }
}