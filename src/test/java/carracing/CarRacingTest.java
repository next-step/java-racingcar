package carracing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;


public class CarRacingTest {
    @ParameterizedTest
    @CsvSource(value = {"0,0", "1,0", "2,0", "3,0", "4,1", "5,1", "6,1", "7,1", "8,1", "9,1"})
    @DisplayName("stepForwardByRandomNunber에서 4 이상이면 한칸 전진 하고, 4미만은 멈춰 있다.")
    void stepFroward(int random, int step) {
        Car car = new Car();
        car.stepForwardByRandomNumber(random);
        assertThat(car.getStep()).isEqualTo(step);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 10, 11, 100})
    @DisplayName("stepForwardByRandomNumber의 randomNumber는 0이상 9이하이다.")
    void invalidRandom(int random) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Car car = new Car();
            car.stepForwardByRandomNumber(random);
        });
    }

    @Test
    @DisplayName("Track getSteps() 테스트")
    void trackGetSteps() {
        Track track = new Track(5);
        List<Integer> steps = track.getSteps();

        assertThat(steps.size()).isEqualTo(5);
        for (int step : steps) {
            assertThat(step).isEqualTo(0);
        }
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 5, 10, 100, 999})
    @DisplayName("Track forward() 테스트")
    void trackForward(int round) {
        Track track = new Track(100);
        for (int i = 0; i < round; i++) {
            track.forward();
        }

        List<Integer> steps = track.getSteps();
        for (int step : steps) {
            assertThat(step).isGreaterThanOrEqualTo(0);
            assertThat(step).isLessThanOrEqualTo(round);
        }
    }
}
