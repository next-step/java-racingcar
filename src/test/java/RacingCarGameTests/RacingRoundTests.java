package RacingCarGameTests;

import domain.dto.RacingCarPosition;
import domain.RacingRound;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

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


    @DisplayName("레이싱 라운드 생성 테스트 - null 케이스")
    @ParameterizedTest
    @NullAndEmptySource
    public void generateRacingRoundNullCasesTest(List<RacingCarPosition> cars) {
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> RacingRound.newInstance(cars))
                .withMessageContaining("car positions is null or empty.");
    }

    private static Stream<Arguments> carPositionCases() {
        return Stream.of(
                Arguments.of(makeRacingCarPositionsTestCases(new String[]{"sonata", "sorento", "tesla"}, new Integer[]{2, 2, 3})),
                Arguments.of(makeRacingCarPositionsTestCases(new String[]{"sonata", "sorento", "tesla", "bike"}, new Integer[]{2, 4, 6, 8})),
                Arguments.of(makeRacingCarPositionsTestCases(new String[]{"sonata", "sorento", "tesla", "bike"}, new Integer[]{0, 2, 0, 5}))
        );
    }

}
