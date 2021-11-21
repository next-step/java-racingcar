package carracing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;


public class CarTest {
    @ParameterizedTest
    @CsvSource(value = {"0,0", "1,0", "2,0", "3,0", "4,1", "5,1", "6,1", "7,1", "8,1", "9,1"})
    @DisplayName("stepForwardByRandomNunber에서 4 이상이면 한칸 전진 하고, 4미만은 멈춰 있다.")
    void stepFroward(int random, int step) {
        Car car = new Car();
        car.stepForwardByRandomNumber(random);
        assertThat(car.getStep()).isEqualTo(step);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, 10})
    void severalStepForwardAlwaysGo(int round) {
        Car car = new Car();
        for (int i = 0; i < round; i++) {
            car.stepForwardByRandomNumber(9);
        }
        assertThat(car.getStep()).isEqualTo(round);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, 10})
    void severalStepForwardNeverGo(int round) {
        Car car = new Car();
        for (int i = 0; i < round; i++) {
            car.stepForwardByRandomNumber(1);
        }
        assertThat(car.getStep()).isEqualTo(0);
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
}
