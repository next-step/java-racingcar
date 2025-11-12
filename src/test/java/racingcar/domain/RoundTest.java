package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class RoundTest {

    @Test
    void 생성자_올바른_값으로_정상적으로_생성() {
        assertThat(new Round(1)).isNotNull();
    }

    @Test
    void 생성자_1_미만이면_예외발생() {
        assertThatThrownBy(() -> new Round(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("최대 라운드 수는 1이상이어야 합니다.");
    }
}
