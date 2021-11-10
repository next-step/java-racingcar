package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

/**
 * @author han
 */
class RacingTest {

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

    @Test
    @DisplayName(value = "생성")
    void create() {
        Racing racing = new Racing(1, 2);
        assertAll(() -> assertThat(racing.getCars().size()).isEqualTo(1),
            () -> assertThat(racing.getAttempts()).isEqualTo(2));
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


    @ParameterizedTest(name = "예상된 랜덤값을 통한 플레이")
    @MethodSource("indexCarsAndResultProvider")
    void playWithExpectedRandomValue(int i, int j, int k) {
        Racing racing = new Racing(3, 3);
        racing.play(new DeterministicRandom());

        List<Car> list = racing.getLogs().get(i);
        assertThat(list.get(j).getStep()).isEqualTo(k);
    }

    @Test
    @DisplayName(value = "잘못 생성 시, 에러를 던진다.")
    void throwExceptionWhenCreated() {
        assertThatThrownBy(() -> new Racing(-1, 1)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Racing(1, -1)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Racing(0, 0)).isInstanceOf(IllegalArgumentException.class);
    }

    static Stream<Arguments> indexCarsAndResultProvider() {
        return Stream.of(
            Arguments.arguments(0,0,0),
            Arguments.arguments(0,1,0),
            Arguments.arguments(0,2,0),
            Arguments.arguments(1,0,0),
            Arguments.arguments(1,1,1),
            Arguments.arguments(1,2,1),
            Arguments.arguments(2,0,1),
            Arguments.arguments(2,1,2),
            Arguments.arguments(2,2,2)
        );
    }
}