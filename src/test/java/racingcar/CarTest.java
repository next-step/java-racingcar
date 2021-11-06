package racingcar;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static racingcar.RacingCarTestUtil.NUM_OF_TRAIALS;
import static racingcar.RacingCarTestUtil.getMaxProgress;

public class CarTest {
    private final String MAX_PROGRESS = getMaxProgress();
    private final int IDENTIFIER_OF_CAR = 1;

    @Test
    void testProgressRun() {
        Car carOne = new Car(IDENTIFIER_OF_CAR);
        progressFiveTimes(carOne);
        assertThat(carOne.getProgress()).isLessThanOrEqualTo(MAX_PROGRESS);
    }

    private void progressFiveTimes(Car car) {
        IntStream.range(0, NUM_OF_TRAIALS)
                .forEach( i ->
                                car.progressRace()
                );
    }
}
