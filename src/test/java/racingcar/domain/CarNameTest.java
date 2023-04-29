package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarNameTest {

    @Test
    @DisplayName("[요구사항 1] 자동차 이름이 5자를 초과할 수 없다.")
    void 요구사항_1() {
        // given
        final String CAR_NAME = "strong";

        // then
        assertThatThrownBy(() -> new CarName(CAR_NAME))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
