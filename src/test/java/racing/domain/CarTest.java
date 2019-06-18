package racing.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static racing.domain.Car.DEFAULT_POSITION;
import static racing.domain.Car.MOVE_THRESHOLD;
import static racing.service.RacingService.RANDOM_NUMBER_BOUND;

class CarTest {

    private Car car;

    @BeforeEach
    void setUp() {
        car = Car.of("pobi");
    }

    @ParameterizedTest(name = "랜덤값이 4 미만이라면 이동하지 않고, 9 이상이라면 이동한다 - randomNumber -> {0}, position -> {1}")
    @MethodSource
    void race(int randomNumber, int position) {

        car.race(randomNumber);

        assertThat(car.getPosition()).isEqualTo(position);
    }

    private static Stream<Arguments> race() {

        return Stream.concat(
                IntStream.range(0, MOVE_THRESHOLD).mapToObj(randomNumber -> Arguments.of(randomNumber, DEFAULT_POSITION)),
                IntStream.range(MOVE_THRESHOLD, RANDOM_NUMBER_BOUND).mapToObj(randomNumber -> Arguments.of(randomNumber, DEFAULT_POSITION + 1)));
    }
}