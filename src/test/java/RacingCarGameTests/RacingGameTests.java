package RacingCarGameTests;

import domain.RacingGame;
import domain.RacingGameResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@DisplayName("레이싱 게임 테스트")
public class RacingGameTests {

    @DisplayName("레이싱 게임 생성 테스트")
    @ParameterizedTest
    @CsvSource({"5,3", "2,6", "7,4"})
    public void generateRacingGameTest(int carNumber, int roundNumber) {
        assertThatCode(() -> RacingGame.create(carNumber, roundNumber)).doesNotThrowAnyException();
    }

    @DisplayName("레이싱 게임 생성 테스트 - 차 대수 비정상 케이스")
    @ParameterizedTest
    @CsvSource({"-1,3", "-2,2", "0,4"})
    public void generateRacingGameAbnormalCarNumberTest(int carNumber, int roundNumber) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> RacingGame.create(carNumber, roundNumber))
                .withMessageMatching("car number must be greater than zero.");
    }

    @DisplayName("레이싱 게임 생성 테스트 - 라운드 갯수 비정상 케이스")
    @ParameterizedTest
    @CsvSource({"2,-4", "3,-3", "5,-1"})
    public void generateRacingGameAbnormalRoundNumberTest(int carNumber, int roundNumber) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> RacingGame.create(carNumber, roundNumber))
                .withMessageMatching("round number must be greater than zero.");
    }

    @DisplayName("레이싱 게임 결과 테스트")
    @ParameterizedTest
    @CsvSource({"4,1", "5,0", "7,4"})
    public void startRacingGameTest(int carNumber, int roundNumber) {
        RacingGame racingGame = RacingGame.create(carNumber, roundNumber);
        RacingGameResult racingGameResult = racingGame.start();
        List<List<Integer>> positionResult = racingGameResult.getResult();

        assertThat(positionResult).hasSize(roundNumber);
        positionResult.stream()
                .forEach(round -> assertRound(round));
    }

    private void assertRound(List<Integer> round) {
        round.stream()
                .forEach(position -> assertThat(position).isGreaterThanOrEqualTo(0));
    }

}
