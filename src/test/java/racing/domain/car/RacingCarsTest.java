package racing.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingCarsTest {

    @ParameterizedTest
    @DisplayName("자동차 이름을 공백으로 받을 때")
    @NullAndEmptySource
    void checkEmptyInputName(String input) {
        assertThatThrownBy(() -> new RacingCars(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름이 비어있습니다. 이름을 입력해주세요.");
    }
}
