package RacingCarGameTests;

import domain.StringOperation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

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
    public void generateRacingRoundAbnormalCasesTest(int[] carPosition) {
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> RacingRound.newInstance(carPosition))
                .withMessageMatching("car position must be greater than zero.");
    }

    private static Stream<Arguments> carPositionCases() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3}),
                Arguments.of(new int[]{2, 4, 6, 8}),
                Arguments.of(new int[]{0, 2, 0, 5})
        );
    }

    private static Stream<Arguments> carPositionAbnormalCases() {
        return Stream.of(
                Arguments.of(new int[]{-1, -2, 3})
        );
    }
}
