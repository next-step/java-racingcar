package RacingCarGameTests;

import domain.RacingCarPosition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@DisplayName("레이싱 게임 포지션 테스트")
public class RacingPositionsTests {

    @DisplayName("레이싱 포지션 생성 테스트")
    @ParameterizedTest
    @CsvSource({"sonata,2", "sorento,2", "tesla,3"})
    public void generateRacingCarPositionTest(String name, Integer locationPoint) {
        assertThatCode(() -> RacingCarPosition.newInstance(name, locationPoint))
                .doesNotThrowAnyException();
    }

    @DisplayName("레이싱 포지션 생성 테스트 - 위치 비정상 케이스")
    @ParameterizedTest
    @CsvSource({"sonata,-2", "sorento,-10"})
    public void generateRacingRoundAbnormalLocationPointsCasesTest(String name, Integer locationPoint) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> RacingCarPosition.newInstance(name, locationPoint))
                .withMessageContaining("car location point must be greater than zero.");
    }

    @DisplayName("레이싱 포지션 생성 테스트 - 차 이름 비정상 케이스")
    @ParameterizedTest
    @CsvSource({",2", "   ,5"})
    public void generateRacingRoundAbnormalNameCasesTest(String name, Integer locationPoint) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> RacingCarPosition.newInstance(name, locationPoint))
                .withMessageContaining("car name is null or empty.");
    }

    @DisplayName("레이싱 포지션 생성 테스트 - null 케이스")
    @ParameterizedTest
    @MethodSource("carPositionNullCases")
    public void generateRacingRoundNullCasesTest(String name, Integer locationPoint) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> RacingCarPosition.newInstance(name, locationPoint))
                .withMessageContaining("is null");
    }

    private static Stream<Arguments> carPositionNullCases() {
        return Stream.of(
                Arguments.of(null, 0),
                Arguments.of("tesla", null)
        );
    }

}
