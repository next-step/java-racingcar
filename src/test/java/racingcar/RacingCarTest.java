package racingcar;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class RacingCarTest {

    @Test
    void 랜덤값() {
        int actual = RacingCar.getRandom();
        assertAll(
                () -> assertThat(actual).isLessThanOrEqualTo(9),
                () -> assertThat(actual).isGreaterThanOrEqualTo(0)
        );
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void 전진(int input) {
        Car actual = new Car();
        actual.move(input);
        assertThat(actual).isEqualTo(new Car(1));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    public void 멈춤(int input) {
        Car actual = new Car();
        actual.move(input);
        assertThat(actual).isEqualTo(new Car(0));
    }
}
