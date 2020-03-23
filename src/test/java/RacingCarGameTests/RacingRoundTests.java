package RacingCarGameTests;

import domain.RacingCarPosition;
import domain.RacingRound;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static utils.TestUtil.makeRacingCarPositionsTestCases;

@DisplayName("레이싱 게임 라운드 테스트")
public class RacingRoundTests {

    @DisplayName("레이싱 라운드 생성 테스트")
    @ParameterizedTest
    @MethodSource("carPositionCases")
    public void generateRacingRoundTest(List<RacingCarPosition> cars) {
        assertThatCode(() -> RacingRound.newInstance(cars))
                .doesNotThrowAnyException();
    }

    @DisplayName("레이싱 라운드 생성 테스트 - 위치 비정상 케이스")
    @ParameterizedTest
    @MethodSource("carPositionAbnormalLocationPointsCases")
    public void generateRacingRoundAbnormalLocationPointsCasesTest(List<RacingCarPosition> cars) {
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> RacingRound.newInstance(cars))
                .withMessageContaining("car position must be greater than zero.");
    }

    @DisplayName("레이싱 라운드 생성 테스트 - 차 이름 비정상 케이스")
    @ParameterizedTest
    @MethodSource("carPositionAbnormalNameCases")
    public void generateRacingRoundAbnormalNameCasesTest(List<RacingCarPosition> cars) {
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> RacingRound.newInstance(cars))
                .withMessageContaining("car names contains blank.");
    }

    @DisplayName("레이싱 라운드 생성 테스트 - null 케이스")
    @ParameterizedTest
    @NullSource
    @MethodSource("carPositionNullCases")
    public void generateRacingRoundNullCasesTest(List<RacingCarPosition> cars) {
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> RacingRound.newInstance(cars))
                .withMessageContaining("car positions contains null.");
    }

    private static Stream<Arguments> carPositionCases() {
        return Stream.of(
                Arguments.of(makeRacingCarPositionsTestCases(new String[]{"sonata", "sorento", "tesla"}, new Integer[]{2, 2, 3})),
                Arguments.of(makeRacingCarPositionsTestCases(new String[]{"sonata", "sorento", "tesla", "bike"}, new Integer[]{2, 4, 6, 8})),
                Arguments.of(makeRacingCarPositionsTestCases(new String[]{"sonata", "sorento", "tesla", "bike"}, new Integer[]{0, 2, 0, 5}))
        );
    }

    private static Stream<Arguments> carPositionAbnormalLocationPointsCases() {
        return Stream.of(
                Arguments.of(makeRacingCarPositionsTestCases(new String[]{"sonata", "sorento", "tesla"}, new Integer[]{-1, -2, 3})),
                Arguments.of(makeRacingCarPositionsTestCases(new String[]{"sonata", "sorento"}, new Integer[]{-1, 3}))
        );
    }

    private static Stream<Arguments> carPositionAbnormalNameCases() {
        return Stream.of(
                Arguments.of(makeRacingCarPositionsTestCases(new String[]{"", "sorento", "tesla", "bike"}, new Integer[]{2, 4, 6, 8})),
                Arguments.of(makeRacingCarPositionsTestCases(new String[]{"sonata", "   ", "tesla", "bike"}, new Integer[]{2, 4, 6, 8}))
                );
    }

    private static Stream<Arguments> carPositionNullCases() {
        return Stream.of(
                Arguments.of(makeRacingCarPositionsTestCases(new String[]{null, "sorento", "tesla"}, new Integer[]{0, 2, 0})),
                Arguments.of(makeRacingCarPositionsTestCases(new String[]{"sonata", "sorento", "tesla"}, new Integer[]{0, 2, null}))
        );
    }

}
