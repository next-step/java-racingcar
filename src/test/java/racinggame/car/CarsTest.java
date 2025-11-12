package racinggame.car;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class CarsTest {

    @Test
    void 자동차_갯수만큼_자동차객체를_생성할_수_있다() {
        assertThat(
                Cars.of(3).size()
        ).isEqualTo(3);
    }
}