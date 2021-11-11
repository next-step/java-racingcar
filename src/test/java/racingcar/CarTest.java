package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static racingcar.Car.*;
import static racingcar.RacingCarTestUtil.NAME_OF_CAR;

public class CarTest {
    private final int INDICATOR_OF_STOP = 0;
    private final int INDICATOR_OF_PROGRESS = 1;
    private static final int STOP_UPPER_BOUNDARY = 3;
    private static final int STOP_LOWER_BOUNDARY_MINUS_ONE = -1;
    private static final int STOP_LOWER_BOUNDARY_PLUS_ONE = 1;
    private static final int RUN_LOWER_BOUNDARY_PLUS_ONE = 5;
    private static final int RUN_UPPER_BOUNDARY_MINUS_ONE = 8;
    private static final int RUN_UPPER_BOUNDARY_PLUS_ONE = 11;

    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car(NAME_OF_CAR);
    }

    @Test
    void testStop() {
        IntStream.rangeClosed(STOP_LOWER_BOUNDARY, STOP_UPPER_BOUNDARY)
                .forEach( i -> {
                    car.initialize();
                    assertThat(car.runOrStop(i)).isEqualTo(INDICATOR_OF_STOP);
                });
    }

    @Test
    void testRun() {
        IntStream.rangeClosed(RUN_LOWER_BOUNDARY, RUN_UPPER_BOUNDARY)
                .forEach( i -> {
                    car.initialize();
                    assertThat(car.runOrStop(i)).isEqualTo(INDICATOR_OF_PROGRESS);
                });
    }

    @Test
    void testBorder() {
        car.initialize();
        assertThat(car.runOrStop(STOP_UPPER_BOUNDARY)).isEqualTo(INDICATOR_OF_STOP);
        car.initialize();
        assertThat(car.runOrStop(RUN_LOWER_BOUNDARY)).isEqualTo(INDICATOR_OF_PROGRESS);
        car.initialize();
        assertThat(car.runOrStop(RUN_LOWER_BOUNDARY_PLUS_ONE)).isEqualTo(INDICATOR_OF_PROGRESS);
    }

    @Test
    void testLowerRange() {
        car.initialize();
        assertThat(car.runOrStop(STOP_LOWER_BOUNDARY)).isEqualTo(INDICATOR_OF_STOP);
        car.initialize();
        assertThat(car.runOrStop(STOP_LOWER_BOUNDARY_PLUS_ONE)).isEqualTo(INDICATOR_OF_STOP);
    }

    @Test
    void testLowerRangeThrowExceptionWhenNumberIsBelowZero() {
        car.initialize();
        assertThatThrownBy(() -> car.runOrStop(STOP_LOWER_BOUNDARY_MINUS_ONE)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void testUpperRange() {
        car.initialize();
        assertThat(car.runOrStop(RUN_UPPER_BOUNDARY_MINUS_ONE)).isEqualTo(INDICATOR_OF_PROGRESS);
        car.initialize();
        assertThat(car.runOrStop(RUN_UPPER_BOUNDARY)).isEqualTo(INDICATOR_OF_PROGRESS);
    }

    @Test
    void testUpperRangeThrowExceptionWhenNumberIsAboveNine() {
        car.initialize();
        assertThatThrownBy(() -> car.runOrStop(RUN_UPPER_BOUNDARY_PLUS_ONE)).isInstanceOf(IllegalArgumentException.class);
    }
}
