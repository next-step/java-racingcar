package racing.race;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racing.input.RaceInput;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static racing.Constants.FORWARD;
import static racing.Constants.STOP;

public class RaceTrackTest {

    @Test
    void race() {
        RaceInput input = new RaceInput(3, 5);
        RaceTrack track = new RaceTrack(new RacingChecker());
        List<Car> racingCars = IntStream.range(0, input.getNumOfCar())
                .mapToObj(i -> new Car())
                .collect(Collectors.toList());

        track.race(input, racingCars);

        for (Car racingCar : racingCars) {
            for (int i = 0; i < input.getNumOfAttempt(); i++) {
                assertThat(racingCar.raceResult())
                        .isBetween(STOP, FORWARD);
            }
            Assertions.assertThatThrownBy(racingCar::raceResult)
                    .isInstanceOf(IndexOutOfBoundsException.class);
        }
    }
}
