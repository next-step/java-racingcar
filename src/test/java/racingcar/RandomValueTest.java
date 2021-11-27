package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.domain.RandomValue;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomValueTest {

    @Test
    void create() {
        assertThat(new RandomValue(3)).isEqualTo(new RandomValue(3));
    }

    @Test
    void canMoveTest() {
        assertThat(new RandomValue(3).resultValue()).isEqualTo(0);
        assertThat(new RandomValue(4).resultValue()).isEqualTo(1);
    }
}
