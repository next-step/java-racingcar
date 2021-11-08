package racing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * @author han
 */
class RacingTest {

    class Racing {
        private List<Car> cars;
        private int attempts;

        public Racing(Integer cars, Integer attempts) {
            if (cars == null || cars.intValue() < 1) {
                throw new IllegalArgumentException();
            }

            if (attempts == null || attempts.intValue() < 1) {
                throw new IllegalArgumentException();
            }
            this.cars = createCars(cars);
            this.attempts = attempts;
        }

        public void play() {

        }

        private List<Car> createCars(int count) {
            return IntStream.range(0, count).mapToObj(i -> new Car()).collect(Collectors.toList());
        }
    }

    @Test
    @DisplayName(value = "생성")
    void create() {
        Racing racing = new Racing(1, 2);
        assertThat(racing).isInstanceOf(Racing.class);
    }

    @Test
    @DisplayName(value = "잘못 생성 시, 에러를 던진다.")
    void throwExceptionWhenCreated() {
        assertThatThrownBy(() -> new Racing(-1, 1)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Racing(1, -1)).isInstanceOf(IllegalArgumentException.class);
    }
}