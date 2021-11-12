package racing;

import helper.NumberHelper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
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
        Racing racing = new Racing(Arrays.asList("1"), 2);
        assertAll(() -> assertThat(racing.getCars().size()).isEqualTo(1),
            () -> assertThat(racing.getAttempts()).isEqualTo(2));
    }

    @Test
    @DisplayName(value = "플레이")
    void play() {
        Racing racing = new Racing(getUsers(NumberHelper.getRandomValue(3) + 1), NumberHelper.getRandomValue(5) + 1);
        List<Car> cars = racing.getCars();

        racing.play(new Random());
        cars.forEach(car -> assertThat(car.getStep()).isGreaterThanOrEqualTo(0));
    }

    @ParameterizedTest(name = "우승자")
    @MethodSource("indexCarsAndResultProvider")
    void winner() {
        Racing racing = new Racing(getUsers(3), 3);
        racing.play(new DeterministicRandom());
        List<Car> winners = racing.getWinners();
        assertThat(winners).extracting("name").contains("2", "3");
    }

    @ParameterizedTest(name = "예상된 랜덤값을 통한 플레이")
    @MethodSource("indexCarsAndResultProvider")
    void playWithExpectedRandomValue(int i, int j, int k) {
        Racing racing = new Racing(getUsers(3), 3);
        racing.play(new DeterministicRandom());

        List<Car> list = racing.getLogs().get(i);
        assertThat(list.get(j).getStep()).isEqualTo(k);
    }

    @ParameterizedTest(name = "잘못 생성 시, 에러를 던진다")
    @MethodSource("carSAndAttemptsProvider")
    void throwExceptionWhenCreated(int cars, int attempts) {
        assertThatThrownBy(() -> new Racing(getUsers(cars), attempts)).isInstanceOf(IllegalArgumentException.class);
    }

    static Stream<Arguments> indexCarsAndResultProvider() {
        return Stream.of(
            Arguments.arguments(0, 0, 0),
            Arguments.arguments(0, 1, 0),
            Arguments.arguments(0, 2, 0),
            Arguments.arguments(1, 0, 0),
            Arguments.arguments(1, 1, 1),
            Arguments.arguments(1, 2, 1),
            Arguments.arguments(2, 0, 1),
            Arguments.arguments(2, 1, 2),
            Arguments.arguments(2, 2, 2)
        );
    }

    static Stream<Arguments> carSAndAttemptsProvider() {
        return Stream.of(
            Arguments.arguments(-1, 1),
            Arguments.arguments(1, -1),
            Arguments.arguments(0, 0)
        );
    }

    List<String> getUsers(int number) {
        return IntStream.rangeClosed(1, number)
            .mapToObj(String::valueOf)
            .collect(Collectors.toList());
    }
}
