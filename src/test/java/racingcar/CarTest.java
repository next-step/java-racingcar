package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static racingcar.Car.*;

public class CarTest {
    private final int IDENTIFIER_OF_CAR = 1;

    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car(IDENTIFIER_OF_CAR);
    }

    @Test
    void testStop() {
        IntStream.rangeClosed(STOP_LOWER_BOUNDARY, STOP_UPPER_BOUNDARY)
                .forEach( i -> {
                    assertThat(car.runOrStop(i)).isEqualTo(false);
                });
    }

    @Test
    void testRun() {
        IntStream.rangeClosed(RUN_LOWER_BOUNDARY, RUN_UPPER_BOUNDARY)
                .forEach( i -> {
                    assertThat(car.runOrStop(i)).isEqualTo(true);
                });
    }
}
