package racing.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class NumberOfCarsTest {

    @DisplayName("음수는 Exception이 발생한다.")
    @ValueSource(ints = { -1 })
    @ParameterizedTest
    void 음수_입력(int number) {
        assertThatThrownBy(() -> NumberOfCars.of(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("음수");
    }

}
