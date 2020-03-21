package RacingCarGameTests;

import domain.RacingGameResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import domain.RacingGame;

import java.util.Arrays;
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

    @DisplayName("레이싱 게임 생성 테스트 - 비정상 케이스")
    @ParameterizedTest
    @NullAndEmptySource
    @CsvSource({"-1,3", "-2,-3", "0,4"})
    public void generateRacingGameAbnormalCasesTest(int carNumber, int roundNumber) {
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> RacingGame.create(carNumber, roundNumber))
                .withMessageMatching("car number and round number must be greater than zero.");
    }

    @DisplayName("레이싱 게임 결과 테스트")
    @ParameterizedTest
    @NullAndEmptySource
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
