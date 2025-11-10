package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class CarNameTest {

    @Test
    void 생성자_null_예외발생() {
        assertThatThrownBy(() -> new CarName(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 null일 수 없습니다.");
    }
}
