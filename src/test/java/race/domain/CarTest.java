package race.domain;

import org.junit.jupiter.api.Test;
import race.constant.Definition;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    void 전진() {
        assertThat(Definition.POBI.canForward(4)).isTrue();
    }

    @Test
    void 정지() {
        assertThat(Definition.POBI.canForward(3)).isFalse();
    }

    @Test
    void 최댓값() {
        assertThat(Math.max(1, 2)).isEqualTo(2);
    }
}
