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
 * 레이싱 라운드 별 기록 저장 테스트
 */
class RacingRoundTest {

    public static final MoveStrategy MOVE_STRATEGY = () -> true;

    private static Stream<Arguments> racingEntry() {
        Car car1 = new Car("a", MOVE_STRATEGY);
        Car car2 = new Car("b", MOVE_STRATEGY);
        Car car3 = new Car("c", MOVE_STRATEGY);
        Car car4 = new Car("d", MOVE_STRATEGY);
        return Stream.of(
                Arguments.of(Arrays.asList(car1, car2, car3), 3),
                Arguments.of(Arrays.asList(car1, car2, car3, car4), 4)
        );
    }

    @DisplayName("레이싱 라운드 기록 테스트")
    @ParameterizedTest(name = "레이싱 참여 한 인원 {1} 체크")
    @MethodSource(value = "racingEntry")
    void racingOfRoundTest(List<Car> entry, int participants) {
        // given
        RacingRound racingRound = new RacingRound(entry);
        // when
        int participantCount = racingRound.getCars().size();
        // then
        assertThat(participantCount).isEqualTo(participants);
    }
}
