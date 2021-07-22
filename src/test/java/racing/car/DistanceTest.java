package racing.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static racing.car.DistanceRange.NOT_MOVEMENT;

class DistanceTest {
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9})
    @DisplayName("new Instance Test")
    @ParameterizedTest
    public void newInstanceTest(int value) {
        Distance distance = Distance.newInstance(value);
        assertThat(distance.getValue())
                .isEqualTo(distance.getDistanceRange() == NOT_MOVEMENT ? NOT_MOVEMENT.getValue() : distance);
    }

    @ValueSource(ints = { -2, -100, 11, 16, 25 })
    @DisplayName("new Instance IllegalArgumentException Test")
    @ParameterizedTest
    public void newIllegalArgumentExceptionInstanceTest(int value) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Distance distance = Distance.newInstance(value);
        });
    }
}