package racingcar.step3_4;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.step3_4.domain.GameAttribute;

class GameAttributeTest {

    @DisplayName("자동차 이름을 1개이상 입력하지 않은 경우 예외 발생")
    @Test
    void createByEmptyNamesTest() {
        List<String> names = List.of();
        assertThatThrownBy(() -> new GameAttribute(names, 5))
            .isExactlyInstanceOf(IllegalArgumentException.class);
    }
}
