package RacingCarGameTests;

import domain.RacingRound;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

@DisplayName("레이싱 게임 라운드 테스트")
public class RacingRoundTests {

    @DisplayName("레이싱 라운드 생성 테스트")
    @ParameterizedTest
    @MethodSource("carPositionCases")
    public void generateRacingRoundTest(RacingCarPosition[] cars) {
        assertThatCode(() -> RacingRound.newInstance(cars))
                .doesNotThrowAnyException();
    }

    @DisplayName("레이싱 라운드 생성 테스트 - 비정상 케이스")
    @ParameterizedTest
    @MethodSource("carPositionAbnormalCases")
    public void generateRacingRoundAbnormalCasesTest(RacingCarPosition[] cars) {
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> RacingRound.newInstance(cars))
                .withMessageContaining("car positions has something errors.");
    }

    private static Stream<Arguments> carPositionCases() {
        return Stream.of(
                Arguments.of(new RacingCarPosition[]{
                        new RacingCarPosition("sonata", 2),
                        new RacingCarPosition("sorento", 2),
                        new RacingCarPosition("tesla", 3)}
                ),
                Arguments.of(new RacingCarPosition[]{
                        new RacingCarPosition("sonata", 2),
                        new RacingCarPosition("sorento", 4),
                        new RacingCarPosition("tesla", 6),
                        new RacingCarPosition("bike", 8)}
                ),
                Arguments.of(new RacingCarPosition[]{
                        new RacingCarPosition("sonata", 0),
                        new RacingCarPosition("sorento", 2),
                        new RacingCarPosition("tesla", 0),
                        new RacingCarPosition("bike", 5)}
                )
        );
    }

    private static Stream<Arguments> carPositionAbnormalCases() {
        return Stream.of(
                Arguments.of(new RacingCarPosition[]{
                        new RacingCarPosition("sonata", -1),
                        new RacingCarPosition("sorento", -2),
                        new RacingCarPosition("tesla", 3)}
                ),
                Arguments.of(new RacingCarPosition[]{
                        new RacingCarPosition("", 2),
                        new RacingCarPosition("sorento", 4),
                        new RacingCarPosition("tesla", 6),
                        new RacingCarPosition("bike", 8)}
                ),
                Arguments.of(new RacingCarPosition[]{
                        new RacingCarPosition(null),
                        new RacingCarPosition("sorento", 2),
                        new RacingCarPosition("tesla", 0),
                        new RacingCarPosition("bike", 5)}
                ),
                Arguments.of(null)
        );
    }
}
