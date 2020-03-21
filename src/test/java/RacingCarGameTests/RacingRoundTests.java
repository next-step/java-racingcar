package RacingCarGameTests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatCode;

@DisplayName("레이싱 게임 라운드 테스트")
public class RacingRoundTests {

    @DisplayName("레이싱 라운드 생성 테스트")
    @ParameterizedTest
    @MethodSource("carPositionCases")
    public void generateRacingRoundTest(int[] carPosition) {
        assertThatCode(() -> RacingRound.newInstance(carPosition)).doesNotThrowAnyException();
    }

    @DisplayName("레이싱 라운드 생성 테스트 - 비정상 케이스")
    @ParameterizedTest
    @MethodSource("carPositionAbnormalCases")
    public void generateRacingRoundTest(int[] carPosition) {
        assertThatCode(() -> RacingRound.newInstance(carPosition)).doesNotThrowAnyException();
    }

    private static Stream<Arguments> carPositionCases() {
        return Stream.of(
                Arguments.of(new int[]{1,2,3}),
                Arguments.of(new int[]{2,4,6,8}),
                Arguments.of(new int[]{0,2,0,5})
        );
    }

    private static Stream<Arguments> carPositionAbnormalCases() {
        return Stream.of(
                Arguments.of(new int[]{-1,-2,3})
        );
    }
}
