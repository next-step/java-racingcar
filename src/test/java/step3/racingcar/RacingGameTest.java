package step3.racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

class RacingGameTest {

    @DisplayName("Racing Game 객체 정상 생성 확인 테스트")
    @ParameterizedTest
    @MethodSource("mockRacingGameBuilder")
    public void testIfRacingGameObjectBuilds(String[] carNames, int gameTryCounts) {
        RacingGame racingGame = new RacingGame(carNames, gameTryCounts);
        assertThat(Arrays.deepEquals(carNames, racingGame.getCarNames())).isTrue();
        assertThat(racingGame.getGameTryCounts()).isEqualTo(gameTryCounts);
    }

    private static Stream<Arguments> mockRacingGameBuilder() {
        return Stream.of(
                Arguments.of("a,b,c,d".split(" "), 5),
                Arguments.of("java,c,js,sql".split(" "), 7),
                Arguments.of("pizza,hamburger,chicken".split(" "), 13)
        );
    }

    @DisplayName("Racing Game 객체 생성되지 않고 IllegalArgumentException 발생 테스트")
    @ParameterizedTest
    @MethodSource("mockRacingGameExceptionBuilder")
    public void throwExceptionWhenBuildingRacingGameObject(String[] carNames, int gameTryCounts) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    RacingGame racingGame = new RacingGame(carNames, gameTryCounts);
                });
    }

    private static Stream<Arguments> mockRacingGameExceptionBuilder() {
        return Stream.of(
                Arguments.of("a,b,c,d".split(" "), 5),
                Arguments.of("java,c,js,sql".split(" "), 7),
                Arguments.of("pizza,hamburger,chicken".split(" "), 13)
        );
    }
}
