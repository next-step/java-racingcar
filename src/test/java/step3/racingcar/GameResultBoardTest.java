package step3.racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
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

    @DisplayName("게임 진행 후 자동차의 위치가 GameResultBoard에 정상 기록됨")
    @ParameterizedTest
    @MethodSource("mockGameResultBoardBuilder")
    public void recordRoundInGameResultBoard(String[] carNames, int gameTryCounts) {
        //Given
        List<Car> cars = CarFactory.makeCars(carNames);
        GameResultBoard gameResultBoard = new GameResultBoard(carNames, gameTryCounts);

        //When
        for (int i = 0; i < gameTryCounts; i++) {
            cars.forEach(Car::move);
            gameResultBoard.recordRound(cars, i);
        }

        //Then
        int[][] resultArray = gameResultBoard.getGameResultBoard();
        for (int[] tmp : resultArray) {
            for (int i = 0; i < tmp.length; i++)
                assertThat(tmp[i]).isGreaterThanOrEqualTo(0);
        }
    }
}
