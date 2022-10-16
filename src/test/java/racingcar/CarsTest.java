package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarsTest {

    // TODO
    private static final String EXCEPTION_MESSAGE_PREFIX = "[ERROR]";

    private Car always50MoveCar;
    private Car always10MoveCar;
    private Car alwaysNonMovableCar;
    private Car alwaysStopCar;

    @BeforeEach
    void setUp() {
        always50MoveCar = CarFactory.getCar(() -> Distance.from(50), () -> true);
        always10MoveCar = CarFactory.getCar(() -> Distance.from(10), () -> true);
        alwaysNonMovableCar = CarFactory.getCar(() -> Distance.from(10), () -> false);
        alwaysStopCar = CarFactory.getCar(() -> Distance.ZERO, () -> true);
    }

    @Test
    void nullCarList() {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new Cars(null))
            .withMessageContaining(EXCEPTION_MESSAGE_PREFIX);
    }

    @Test
    void emptyCarList() {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new Cars(Collections.emptyList()))
            .withMessageContaining(EXCEPTION_MESSAGE_PREFIX);
    }

    @Test
    void containsNullCar() {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new Cars(Arrays.asList(always50MoveCar, null, always10MoveCar)))
            .withMessageContaining(EXCEPTION_MESSAGE_PREFIX);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 5, 10})
    void move(final int count) {
        final Cars cars = new Cars(
            List.of(always50MoveCar, always10MoveCar, alwaysNonMovableCar, alwaysStopCar));

        for (int i = 0; i < count; i++) {

            Distance prevAlways50MoveCarDistance = always50MoveCar.getDistance();
            Distance prevAlways10MoveCarDistance = always10MoveCar.getDistance();

            cars.move();

            assertThat(always50MoveCar.getDistance()).
                isEqualTo(prevAlways50MoveCarDistance.plus(Distance.from(50)));
            assertThat(always10MoveCar.getDistance())
                .isEqualTo(prevAlways10MoveCarDistance.plus(Distance.from(10)));

            assertThat(alwaysNonMovableCar.getDistance())
                .isEqualTo(Distance.ZERO);
            assertThat(alwaysStopCar.getDistance())
                .isEqualTo(Distance.ZERO);

            prevAlways50MoveCarDistance = always50MoveCar.getDistance();
            prevAlways10MoveCarDistance = always10MoveCar.getDistance();
        }
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 5, 10})
    void getDistances(final int count) {
        final Cars cars = new Cars(
            List.of(always50MoveCar, always10MoveCar, alwaysNonMovableCar, alwaysStopCar));

        for (int i = 0; i < count; i++) {
            cars.move();
        }

        final List<Distance> distances = cars.getDistances();
        assertThat(distances.size())
            .isEqualTo(4);
        assertThat(distances)
            .containsExactly(always50MoveCar.getDistance(),
                always10MoveCar.getDistance(),
                alwaysNonMovableCar.getDistance(),
                alwaysStopCar.getDistance());
    }
}
