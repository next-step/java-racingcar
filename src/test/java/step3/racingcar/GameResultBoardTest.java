package step3.racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class GameResultBoardTest {

    @DisplayName("GameResultBoard 객체가 정상 생성되는지 확인하는 테스트")
    @ParameterizedTest
    @MethodSource("mockGameResultBoardBuilder")
    public void getGameResultBoardObject(String[] carNames, int gameTryCounts) {
        GameResultBoard gameResultBoard = new GameResultBoard(carNames, gameTryCounts);
        assertThat(gameResultBoard.getGameResultBoard().length).isEqualTo(carNames.length);
        assertThat(gameResultBoard.getGameResultBoard()[0].length).isEqualTo(gameTryCounts);
    }

    private static Stream<Arguments> mockGameResultBoardBuilder() {
        return Stream.of(
                Arguments.of("a,b,c,d".split(","), 5),
                Arguments.of("java,c,js,sql".split(","), 7),
                Arguments.of("pizza,hamburger,chicken".split(","), 13)
        );
    }
}
