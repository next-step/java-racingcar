package step5.racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import step5.racingcar.domain.RacingGame;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

class RacingGameTest {

    @DisplayName("Racing Game 객체 정상 생성 확인 테스트")
    @ParameterizedTest
    @MethodSource("mockRacingGameBuilder")
    public void testIfRacingGameObjectBuilds(String[] carNames, int gameTryCounts) {
        RacingGame racingGame = new RacingGame(carNames, gameTryCounts);

        assertThat(Arrays.asList(carNames))
                .isEqualTo(racingGame.getPlayerCars().getCarNames());
        assertThat(racingGame.getGameTryCounts()).isEqualTo(gameTryCounts);
    }

    private static Stream<Arguments> mockRacingGameBuilder() {
        return Stream.of(
                Arguments.of("a,b,c,d".split(","), 5),
                Arguments.of("java,c,js,sql".split(","), 7),
                Arguments.of("pizza,hamburger,chicken".split(","), 13)
        );
    }

    @DisplayName("game이 1회 진행되면 시도 회수 정상 감소하는 테스트")
    @ParameterizedTest
    @MethodSource("mockRacingGameBuilder")
    public void minusGameTryCountsWhenMoving(String[] carNames, int gameTryCounts) {
        RacingGame racingGame = new RacingGame(carNames, gameTryCounts);

        assertThat(racingGame.hasNextRound()).isEqualTo(true);

        racingGame.run();

        assertThat(racingGame.getGameTryCounts()).isEqualTo(gameTryCounts - 1);
    }

    @DisplayName("gameTryCounts가 부족하면 game이 진행되지 않는 테스트")
    @Test
    public void cannotPlayGameWhenCountsNotEnough() {
        RacingGame racingGame = new RacingGame(new String[]{"a", "b"}, 1);

        assertThat(racingGame.hasNextRound()).isEqualTo(true);

        racingGame.run();

        assertThat(racingGame.getGameTryCounts()).isEqualTo(0);
        assertThat(racingGame.hasNextRound()).isEqualTo(false);
        assertThatExceptionOfType(IllegalStateException.class)
                .isThrownBy(() -> {
                    racingGame.run();
                });
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
                Arguments.of("java,c,js,sql".split(","), 0),
                Arguments.of("pizza,hamburger,chicken".split(","), -3),
                Arguments.of("".split(","), 8),
                Arguments.of(",".split(","), 8),
                Arguments.of(",,,".split(","), 8)
        );
    }
}
