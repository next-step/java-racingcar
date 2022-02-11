package racing.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RacingTest {

    @Test
    void 레이스를_실행하면서_남은_라운드_수가_갱신된다() {
        Racing racing = new Racing(5);
        racing.race();

        assertThat(racing.getRoundNumber()).isEqualTo(0);
    }
}
