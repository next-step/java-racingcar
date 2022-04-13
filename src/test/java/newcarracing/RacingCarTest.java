package newcarracing;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacingCarTest {
    @ParameterizedTest
    @ValueSource(strings = {"pobi", "crong", "honux"})
    void 경주용_자동차(String input) {
        RacingCar racingCar = new RacingCar(input);
        assertThat(racingCar.getName()).isEqualTo(input);
    }

    @Test
    void 경주용_자동차_이름_길이_제한초과() {
        assertThatThrownBy(() -> {
            RacingCar racingCar = new RacingCar("carname");
        })
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("초과")
        ;
    }

    @Test
    void 경주용_자동차_한칸_전진() {
        RacingCar racingCar = new RacingCar("pobi");
        racingCar.moveForward();
        assertThat(racingCar.getPosition()).isEqualTo(1);
    }
}