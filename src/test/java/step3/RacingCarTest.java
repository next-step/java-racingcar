package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import step2.Operator;
import step3.domain.ForwardMoveStrategy;
import step3.domain.RacingCar;
import step3.domain.StopMoveStrategy;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarTest {

    private static final String TEST_CAR_NAME = "TEST";

    @DisplayName("ForwardMoveStrategy는 자동차의 position을 1씩 증가시킨다")
    @Test
    void carForwardMovingTest() {
        RacingCar racingCar = RacingCar.create(TEST_CAR_NAME);

        assertThat(racingCar.move(new ForwardMoveStrategy())).isEqualTo(1);
        assertThat(racingCar.move(new ForwardMoveStrategy())).isEqualTo(2);
        assertThat(racingCar.move(new ForwardMoveStrategy())).isEqualTo(3);
    }

    @DisplayName("StopMoveStrategy는 자동차의 position이 증가하지 않는다")
    @Test
    void carStopMovingTest() {
        RacingCar racingCar = RacingCar.create(TEST_CAR_NAME);

        assertThat(racingCar.move(new StopMoveStrategy())).isEqualTo(0);
        assertThat(racingCar.move(new StopMoveStrategy())).isEqualTo(0);
        assertThat(racingCar.move(new StopMoveStrategy())).isEqualTo(0);
    }

    @DisplayName("RacingCars의 toString()은 자동차의 이름과 위치 정보를 '-' 문자로 나타낸다")
    @ParameterizedTest
    @MethodSource("provideSourceForToString")
    void toStringTest(String carName, int moveCount, String expectedPosition) {
        RacingCar racingCar = RacingCar.create(carName);

        IntStream.range(0, moveCount).forEach(i -> racingCar.move(new ForwardMoveStrategy()));

        assertThat(racingCar.toString()).isEqualTo(carName + " : " + expectedPosition);
    }

    private static Stream<Arguments> provideSourceForToString() {
        return Stream.of(
                Arguments.of("TEST1", 3, "---"),
                Arguments.of("TEST2", 5, "-----"),
                Arguments.of("TEST3", 7, "-------")
        );
    }
}
