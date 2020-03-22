package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class RacingGameTest {
    @Test
    @DisplayName("자동차의 대수는 0 이상이어야 한다.")
    void carNumTest() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new RacingGame(Collections.emptyList()));
    }
}