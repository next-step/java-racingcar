package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RacingManagerTest {
    private final int NUMBER_OF_TRIALS = 10;
    private final int NUMBER_OF_CARS = 5;
    private final int STARTING_NUMBER_OF_CAR = 1;

    private List<Car> cars;

    @BeforeEach
    void setUp() {
        cars = new ArrayList<>();
        IntStream.rangeClosed(STARTING_NUMBER_OF_CAR, NUMBER_OF_CARS)
                .forEach(i -> cars.add(new Car(i)));
    }

    @Test
    void testRacingManager() {
        RacingManager racingManager = new RacingManager(NUMBER_OF_TRIALS, cars);
        int racingRound = racingManager.startRacing(new ConsoleOutputView());
        assertThat(racingRound).isEqualTo(NUMBER_OF_TRIALS);
    }
}
