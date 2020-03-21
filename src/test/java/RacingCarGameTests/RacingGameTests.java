package RacingCarGameTests;

import org.assertj.core.api.Condition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

@DisplayName("레이싱 게임 테스트")
public class RacingGameTests {

    @DisplayName("레이싱 게임 생성 테스트")
    @ParameterizedTest
    @CsvSource({"5,3", "2,6", "7,4"})
    public void generateRacingGameTest(int carNumber, int roundNumber) {
        assertThatCode(() -> RacingGame.newInstance(carNumber, roundNumber)).doesNotThrowAnyException();
    }

    @DisplayName("레이싱 게임 생성 테스트 - 비정상 케이스")
    @ParameterizedTest
    @NullAndEmptySource
    @CsvSource({"-1,3", "-2,-3", "0,4"})
    public void generateRacingGameAbnormalCasesTest(int carNumber, int roundNumber) {
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> RacingGame.newInstance(carNumber, roundNumber))
                .withMessageMatching("car number and round number must be greater than zero.");
    }

    @DisplayName("레이싱 게임 결과 테스트")
    @ParameterizedTest
    @NullAndEmptySource
    @CsvSource({"4,1", "5,0", "7,4"})
    public void startRacingGameTest(int carNumber, int roundNumber) {
        RacingGame racingGame = RacingGame.newInstance(carNumber, roundNumber);
        RacingGameResult racingGameResult = racingGame.start();
        int[] positionResult = racingGameResult.toArray();

        assertThat(positionResult).hasSize(carNumber);
        Arrays.stream(positionResult)
                .forEach(number -> assertThat(number).isGreaterThanOrEqualTo(0));
    }

}
