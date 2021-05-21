package racingcar;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class RacingcarTest {

    @ParameterizedTest
    @ValueSource(strings = {"fight, gw, hw"})
    void nameCheckTest(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new RacingCar(input);
        });
    }

    @Test
    void moveTest() {
        RacingCar racingCar= new RacingCar("fg");
        racingCar.moveOrNot(4);
        assertThat(racingCar.getPosition()).isEqualTo(1);
    }

    @Test
    void stopTest() {
        RacingCar racingCar= new RacingCar("fg");
        racingCar.moveOrNot(3);
        assertThat(racingCar.getPosition()).isEqualTo(0);
    }
}
