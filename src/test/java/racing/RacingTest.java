package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Random;

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

    @Test
    @DisplayName(value = "플레이")
    void play() {
        Racing racing = new Racing(NumberHelper.getRandomValue(3) + 1, NumberHelper.getRandomValue(5) + 1);
        List<Car> cars = racing.getCars();
        int attempts = racing.getAttempts();

        assertThat(cars.size()).isGreaterThanOrEqualTo(1);
        assertThat(attempts).isGreaterThanOrEqualTo(1);

        racing.play(new Random());
        cars.forEach(car -> assertThat(car.getStep()).isGreaterThanOrEqualTo(0));
    }

    @Test
    @DisplayName(value = "예상된 랜덤값을 통한 플레이")
    void playWithExpectedRandomValue() {
        Racing racing = new Racing(3, 5);
        List<Car> cars = racing.getCars();
        int attempts = racing.getAttempts();

        assertThat(cars.size()).isEqualTo(3);
        assertThat(attempts).isEqualTo(5);

        racing.play(new DeterministicRandom());

        Map<Integer, List<Car>> logs = racing.getLogs();

        List<Car> cars1 = logs.get(0);

        assertThat(cars1.get(0).getStep()).isEqualTo(0);
        assertThat(cars1.get(1).getStep()).isEqualTo(0);
        assertThat(cars1.get(2).getStep()).isEqualTo(0);

        List<Car> cars2 = logs.get(1);

        assertThat(cars2.get(0).getStep()).isEqualTo(0);
        assertThat(cars2.get(1).getStep()).isEqualTo(0);
        assertThat(cars2.get(2).getStep()).isEqualTo(1);

        List<Car> cars3 = logs.get(2);

        assertThat(cars3.get(0).getStep()).isEqualTo(1);
        assertThat(cars3.get(1).getStep()).isEqualTo(1);
        assertThat(cars3.get(2).getStep()).isEqualTo(2);
    }

    @Test
    @DisplayName(value = "잘못 생성 시, 에러를 던진다.")
    void throwExceptionWhenCreated() {
        assertThatThrownBy(() -> new Racing(-1, 1)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Racing(1, -1)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Racing(0, 0)).isInstanceOf(IllegalArgumentException.class);
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