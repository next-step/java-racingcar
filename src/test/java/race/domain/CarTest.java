package race.domain;

import org.junit.jupiter.api.Test;
import race.fixture.CarFixtures;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    void 전진() {
        assertThat(CarFixtures.POBI.canForward(4)).isTrue();
    }

    @Test
    void 정지() {
        assertThat(CarFixtures.POBI.canForward(3)).isFalse();
    }
}
