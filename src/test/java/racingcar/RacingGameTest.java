package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.domain.game.RacingGame;
import racingcar.domain.game.RacingGameResult;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;


public class RacingGameTest {

    @MethodSource("provideValidArgument")
    @ParameterizedTest
    @DisplayName("RacingGame 객체 생성 테스트")
    public void generateRacingGameTest(int round, String[] carNames) {
        assertThat(new RacingGame(round, carNames)).isExactlyInstanceOf(RacingGame.class);
    }

    @MethodSource("provideInValidArgument")
    @ParameterizedTest
    @DisplayName("RacingGame 객체 생성 예외 테스트")
    public void generateRacingGameExceptionTest(int round, String[] carNames) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new RacingGame(round, carNames));
    }

    @MethodSource("provideValidArgument")
    @ParameterizedTest
    @DisplayName("RacingGame play 결과의 크기는 검증한다.")
    public void playTest(int round, String[] carNames) {
        RacingGameResult racingGameResult = new RacingGame(round, carNames).play();
        assertThat(racingGameResult.getResults().keySet().size()).isEqualTo(carNames.length);
        assertThat(racingGameResult.getResults().values().size()).isEqualTo(carNames.length);
    }

    @MethodSource("provideValidArgument")
    @ParameterizedTest
    @DisplayName("RacingGame 객체 생성 후 생성된 차의 크기는 입력 된 차 이름의 크기와 같다.")
    public void generateCarsTest(int round, String[] carNames) {
        assertThat(new RacingGame(round, carNames).getCars().getCars()).hasSize(carNames.length);
    }


    private static Stream<Arguments> provideValidArgument() {
        return Stream.of(
                Arguments.of(3, new String[]{"tokyo", "berlin", "professor"}),
                Arguments.of(2, new String[]{"sonata", "ray", "k5"}),
                Arguments.of(4, new String[]{"k9", "volvo", "sm5"})
        );
    }

    private static Stream<Arguments> provideInValidArgument() {
        return Stream.of(
                Arguments.of(3, new String[]{"k5"}),
                Arguments.of(0, new String[]{"k5", "sonata"}),
                Arguments.of(-1, new String[]{"k5", "sonata"}),
                Arguments.of(0, new String[]{"k5", "sonata"}),
                Arguments.of(3, null));
    }
}
