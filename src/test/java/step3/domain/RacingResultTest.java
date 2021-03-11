package step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
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
        Car car1 = new Car("a", MOVE_STRATEGY);
        Car car2 = new Car("b", MOVE_STRATEGY);
        Car car3 = new Car("c", MOVE_STRATEGY);
        Car car4 = new Car("d", MOVE_STRATEGY);
        return Stream.of(
                Arguments.of(Arrays.asList(car1, car2, car3), 1),
                Arguments.of(Arrays.asList(car1, car2, car3, car4), 1)
        );
    }
    private static Stream<Arguments> racingWinnerEntry() {
        Car car1 = new Car("a", 0, MOVE_STRATEGY);
        Car car2 = new Car("b", 0, MOVE_STRATEGY);
        Car car3 = new Car("c", 3, MOVE_STRATEGY);
        Car car4 = new Car("d", 4, MOVE_STRATEGY);
        Car car5 = new Car("e", 4, MOVE_STRATEGY);
        return Stream.of(
                Arguments.of(Arrays.asList(car1, car2, car3), new String[] {"c"}),
                Arguments.of(Arrays.asList(car1, car2, car3, car4), new String[] {"d"}),
                Arguments.of(Arrays.asList(car1, car2, car3, car4, car5), new String[] {"d", "e"})
        );
    }

    @DisplayName("레이싱 결과를 확인하기 위한 컬렉션 사이즈 확인 테스트")
    @ParameterizedTest(name = "레이싱 라운드 수 {1}")
    @MethodSource(value = "racingEntry")
    void getRacingRound(List<Car> cars, int roundNumber) {
        // given
        RacingRound racingRound = new RacingRound(cars);
        // when
        RacingResult racingResult = new RacingResult();
        racingResult.addRacingRound(racingRound);

        List<RacingRound> racingRounds = racingResult.getRacingRounds();
        int size = racingRounds.size();

        // then
        assertThat(size).isEqualTo(roundNumber);

        racingRounds.forEach(round ->
                assertThat(round.getCars().size()).isEqualTo(cars.size())
        );
    }

    @DisplayName("레이싱 결과 우승자 확인 테스트")
    @ParameterizedTest(name = "레이싱 엔트리 결과 Winner 확인 {1}")
    @MethodSource(value = "racingWinnerEntry")
    void getRacingWinner(List<Car> cars, String[] winnerName) {
        // given
        RacingRound racingRound = new RacingRound(cars);
        // when
        RacingResult racingResult = new RacingResult();
        racingResult.addRacingRound(racingRound);
        // then
        String[] winner = racingResult.getWinner();
        assertThat(winner).containsExactly(winnerName);
    }
}
