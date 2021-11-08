package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * @author han
 */
class RacingTest {

    @Test
    @DisplayName(value = "생성")
    void create() {
        Racing racing = new Racing(1, 2);
        assertThat(racing.getCars().size()).isEqualTo(1);
        assertThat(racing.getAttempts()).isEqualTo(2);
    }

    @RepeatedTest(name = "플레이", value = 10)
    void play() {
        Racing racing = new Racing(NumberHelper.getRandomValue(3) + 1, NumberHelper.getRandomValue(5) + 1);
        List<Car> cars = racing.getCars();
        int attempts = racing.getAttempts();

        assertThat(cars.size()).isGreaterThanOrEqualTo(1);
        assertThat(attempts).isGreaterThanOrEqualTo(1);

        racing.play();
        cars.forEach(car -> assertThat(car.getStep()).isGreaterThanOrEqualTo(0));
    }

    @Test
    @DisplayName(value = "잘못 생성 시, 에러를 던진다.")
    void throwExceptionWhenCreated() {
        assertThatThrownBy(() -> new Racing(-1, 1)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Racing(1, -1)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Racing(0,0)).isInstanceOf(IllegalArgumentException.class);
    }

    class DeterministicRandom extends Random {
        int sequentialNum = 0;

        public DeterministicRandom() {
            super();
        }

        @Override
        public int nextInt(int input) {
            return sequentialNum++;
        }
    }
}