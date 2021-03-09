package step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import step3.move.MoveStrategy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 레이싱 라운드 컬렉션을 테스트
 */
class RacingResultTest {

    public static final MoveStrategy MOVE_STRATEGY = () -> true;

    private static Stream<Arguments> racingEntry() {
        Car car1 = new Car(0, MOVE_STRATEGY);
        Car car2 = new Car(1, MOVE_STRATEGY);
        Car car3 = new Car(3, MOVE_STRATEGY);
        Car car4 = new Car(4, MOVE_STRATEGY);
        return Stream.of(
                Arguments.of(Arrays.asList(car1, car2, car3), 1),
                Arguments.of(Arrays.asList(car1, car2, car3, car4), 1)
        );
    }

    @DisplayName("레이싱 결과를 확인하기 위한 컬렉션 사이즈 확인 테스트")
    @ParameterizedTest(name = "레이싱 라운드 수 {1}")
    @MethodSource(value = "racingEntry")
    void racing(List<Car> cars, int attemptCount) {
        // given
        RacingRound racingRound = new RacingRound(cars);
        // when
        RacingResult racingResult = new RacingResult();
        racingResult.addRacingRound(racingRound);

        List<RacingRound> racingRounds = racingResult.getRacingRounds();
        int size = racingRounds.size();

        // then
        assertThat(size).isEqualTo(attemptCount);

        racingRounds.forEach(round ->
                assertThat(round.getCars().size()).isEqualTo(cars.size())
        );
    }
}
