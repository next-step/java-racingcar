package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.Car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class CarTest {

    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car("car1");
    }

    @DisplayName(value = "빈 문자열 또는 null 값을 입력할 경우 IllegalArgumentException 이 발생")
    @ParameterizedTest
    @NullAndEmptySource
    void emptyOrNull(final String textInput) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Car(textInput));
    }

    @DisplayName("0보다 작은 위치가 입력할 경우 IllegalArgumentException 이 발생")
    @ParameterizedTest
    @ValueSource(ints = {-1})
    void carPosition(int position) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Car("car1", position));
    }
}
