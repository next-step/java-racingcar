package racingGame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingGame.racingRule.FowardRule;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    private FowardRule fowardRule = new FowardRule();

    private static Stream<Arguments> provideInputParameter() {
        return Stream.of(
                Arguments.of("A", "2"),
                Arguments.of("B", "2"),
                Arguments.of("V", "2")
        );
    }

    @ParameterizedTest
    @MethodSource("provideInputParameter")
    @DisplayName("차 대수와 시행 횟수를 입력한 만큼 게임을 진행한다.")
    void when_play_create_cars(String carNum, String tryNum) {
        //given
        InputParameters testInput = new InputParameters(carNum, tryNum);
        RacingGame game = new RacingGame(testInput);
        //when
        Cars result = game.play(fowardRule);
        //then
        assertThat(result.getCars()).hasSize(1);
        assertThat(result.getCars().get(0).getPosition()).isEqualTo(Integer.parseInt(tryNum));
    }
}
