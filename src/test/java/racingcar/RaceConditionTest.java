package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import racingcar.domain.RaceCondition;

public class RaceConditionTest {
    @Test
    void 전진조건_테스트() {
        assertThat(new RaceCondition(1, 4).getCondition()).isEqualTo(false);
        assertThat(new RaceCondition(10, 0).getCondition()).isEqualTo(true);
    }
}
