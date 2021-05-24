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
            new Car(input);
        });
    }

    @Test
    void moveTest() {
        Car car = new Car("fg");
        car.moveOrNot(4);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void stopTest() {
        Car car = new Car("fg");
        car.moveOrNot(3);
        assertThat(car.getPosition()).isEqualTo(0);
    }
}
