package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.util.MovingGenerator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static racingcar.model.RacingGame.GAME_END_ROUND;
import static racingcar.model.RacingGame.INPUT_MIN_VALUE;

public class RacingGameTest {

    @Test
    @DisplayName("레이싱을 한번 진행한 결과를 반환한다")
    void racing() {
        int round = 1;
        int carCount = 2;

        RacingGame racingGame = new RacingGame(round, Cars.newInstance(carCount), new MovingGenerator());

        Cars result = racingGame.racing();

        assertThat(result.getCars()).extracting(Car::getPosition).containsOnly(2);
    }

    @ParameterizedTest
    @CsvSource({
            "-1, 0, 시도 횟수는 " + INPUT_MIN_VALUE + "보다 커야합니다.",
            "0, -1, 자동차 대수는 " + INPUT_MIN_VALUE + "보다 커야합니다."
    })
    void inputWrongValueFail(int round, int carCount, String errorMessage) {
       assertThatIllegalArgumentException()
               .isThrownBy(() -> RacingGame.generate(round, carCount))
               .withMessageMatching(errorMessage);
    }

    @Test
    @DisplayName("횟수가 " + GAME_END_ROUND + "이면 게임종료")
    void timeZeroThenGameOver() {
        RacingGame racingGame = RacingGame.generate(0, 3);
        assertThat(racingGame.isGameOver()).isTrue();
    }

    @Test
    @DisplayName("횟수가 " + GAME_END_ROUND + "이 아닐 시 게임진행")
    void timeNoZeroThenGameOver() {
        RacingGame racingGame = RacingGame.generate(3, 3);
        assertThat(racingGame.isGameOver()).isFalse();
    }
}