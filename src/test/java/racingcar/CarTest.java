package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static racingcar.Car.RUN_LOWER_BOUNDARY;

public class CarTest {
    private final int IDENTIFIER_OF_CAR = 1;
    private final int INDICATOR_OF_STOP = 0;
    private final int INDICATOR_OF_PROGRESS = 1;
    public static final int STOP_LOWER_BOUNDARY = 0;
    public static final int STOP_UPPER_BOUNDARY = 3;
    public static final int RUN_UPPER_BOUNDARY = 10;

    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car(IDENTIFIER_OF_CAR);
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
        int distance = IntStream.rangeClosed(STOP_UPPER_BOUNDARY, RUN_LOWER_BOUNDARY)
                .map(i -> car.runOrStop(i))
                .sum();
        assertThat(distance).isEqualTo(INDICATOR_OF_PROGRESS);
    }
}
