package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.domain.MovingStrategy;
import racingcar.domain.RacingCarGame;
import racingcar.domain.RacingCarGameRule;
import racingcar.dto.CarScore;
import racingcar.dto.FinalScoreBoard;
import racingcar.dto.RacingCarGameRequest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalStateException;

public class RacingCarGameTest {

    private RacingCarGameRequest createRacingCarGameRequest(int totalPlayCount) {
        return createRacingCarGameRequest(totalPlayCount, new String[]{"abad", "dfsd", "ddd"});
    }

    private RacingCarGameRequest createRacingCarGameRequest(int totalPlayCount, String[] carNameArray) {
        return new RacingCarGameRequest(totalPlayCount, carNameArray);
    }

    private MovingStrategy createFixedMovingStrategy(int movableCount) {
        return new MovingStrategy() {

            private int count = movableCount;

            @Override
            public boolean isMovable() {
                count--;
                return count > 0;
            }
        };
    }

    @ParameterizedTest
    @CsvSource(value = {"4:2:false", "5:5:true"}, delimiter = ':')
    @DisplayName("자동차 게임 isDone 메서드를 통해 finalScoreBoard에 정상적으로 추가 되는지 count는 늘어나는지 테스트")
    void play(int totalPlayCount, int actualPlayCount, boolean expected) {
        RacingCarGame game = new RacingCarGame(new RacingCarGameRule(), createRacingCarGameRequest(totalPlayCount));
        for (int i = 0; i < actualPlayCount; i++) {
            game.play();
        }
        assertThat(game.isDone()).isEqualTo(expected);
        assertThat(game.getFinalScoreBoard().getAllScore().size()).isEqualTo(actualPlayCount);
    }

    @ParameterizedTest
    @CsvSource(value = {"4:6:3"}, delimiter = ':')
    @DisplayName("자동차 게임 최초 요청 횟수보다 더 많이 play했을때 exception 발생 테스트")
    void isPlayThrowExceptionWhenPlayMoreThanPlayCount(int totalPlayCount, int actualPlayCount, int carNumber) {
        RacingCarGame game = new RacingCarGame(new RacingCarGameRule(), createRacingCarGameRequest(totalPlayCount));
        assertThatIllegalStateException().isThrownBy(() -> {
            for (int i = 0; i < actualPlayCount; i++) {
                game.play();
            }
        });
    }


    @ParameterizedTest
    @CsvSource(value = {"abc,sdd,addd:4,3,2:abc", "abc,sdd,addd:4,7,2:sdd"}, delimiter = ':')
    @DisplayName("자동차 게임 결과물 finalScoreBoard에 한명의 우승자가 있는 경우 테스트")
    void getFinalScoreBoardWithSingleWinner(String carNames, String travelledDistances, String expectedWinnerName) {
        int fixedPlayCount = 1;
        int expectedWinnerNumber = 1;
        String nameSeparator = ",";

        String[] carNameArray = carNames.split(nameSeparator);
        String[] travelledDistanceArray = travelledDistances.split(nameSeparator);

        FinalScoreBoard finalScoreBoard = new FinalScoreBoard();
        List<CarScore> carScoreList = new ArrayList<>();
        finalScoreBoard.add(fixedPlayCount, carScoreList);
        for (int i = 0; i < carNameArray.length; i++) {
            carScoreList.add(new CarScore(carNameArray[i], Integer.parseInt(travelledDistanceArray[i])));
        }
        List<CarScore> finalWinnerList = finalScoreBoard.getFinalWinner();

        assertThat(finalWinnerList.size()).isEqualTo(expectedWinnerNumber);
        for (CarScore carScore : finalWinnerList) {
            assertThat(carScore.getCarName()).isEqualTo(expectedWinnerName);
        }
    }

    @ParameterizedTest
    @CsvSource(value = {"abc,sdd,addd:4,4,2:abc,sdd", "abc,sdd,addd,pobi,crong:4,7,2,7,7:crong,pobi,sdd"}, delimiter = ':')
    @DisplayName("자동차 게임 결과물 finalScoreBoard에 여러명의 우승자가 있는 경우 테스트")
    void getFinalScoreBoardWithMultipleWinner(String carNames, String travelledDistances, String expectedWinnerNames) {
        String nameSeparator = ",";
        String[] carNameArray = carNames.split(nameSeparator);
        String[] travelledDistanceArray = travelledDistances.split(nameSeparator);
        List<String> expectedWinnerNameList = new ArrayList<>(Arrays.asList(expectedWinnerNames.split(nameSeparator)));

        int expectedWinnerNumber = expectedWinnerNameList.size();
        int fixedPlayCount = 1;

        FinalScoreBoard finalScoreBoard = new FinalScoreBoard();
        List<CarScore> carScoreList = new ArrayList<>();
        finalScoreBoard.add(fixedPlayCount, carScoreList);
        for (int i = 0; i < carNameArray.length; i++) {
            carScoreList.add(new CarScore(carNameArray[i], Integer.parseInt(travelledDistanceArray[i])));
        }
        List<CarScore> finalWinnerList = finalScoreBoard.getFinalWinner();

        assertThat(finalWinnerList.size()).isEqualTo(expectedWinnerNumber);
        for (CarScore carScore : finalWinnerList) {
            assertThat(expectedWinnerNameList.contains(carScore.getCarName())).isTrue();
        }
    }

}
