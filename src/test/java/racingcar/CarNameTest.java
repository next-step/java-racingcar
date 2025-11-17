package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarNameTest {

    @DisplayName("올바른 이름이면 CarName이 생성된다")
    @ParameterizedTest
    @ValueSource(strings = {"a", "car05"})
    void createCarName(String name) {
        assertThat(new CarName(name)).isNotNull();
    }

    @DisplayName("이름이 빈 값이거나 5자 초과인 경우 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(strings = {"", "   ", "car006"})
    void carNameLongThrowsException(String name) {
        assertThatThrownBy(() -> new CarName(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름");
    }
}
