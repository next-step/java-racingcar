package racingcar.step3_4;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameAttributeTest {

    @DisplayName("자동차 이름을 1개이상 입력하지 않은 경우 예외 발생")
    @Test
    void createByEmptyNamesTest() {
        Names names = Names.of(new String[]{});
        assertThatThrownBy(() -> new GameAttribute(names, 5))
            .isExactlyInstanceOf(IllegalArgumentException.class);
    }
}
