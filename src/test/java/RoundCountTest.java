import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RoundCountTest {
    @Test
    @DisplayName("진행 횟수는 1이상이어야 한다.")
    void inValidRoundCount() {
        assertThatThrownBy(() -> new RoundCount(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("진행 횟수는 1 이상이어야 합니다.");
    }
}