package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.util.MovingGenerator;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    private static final String SAMPLE_NAMES = "test1,test2";

    @Test
    @DisplayName("레이싱 한번한 결과를 반환한다")
    void playOfOneRound() {
        RacingGame racingGame = new RacingGame(Cars.from(SAMPLE_NAMES), new MovingGenerator());
        Cars result = racingGame.playOfOneRound();
        assertThat(result.getCars())
                .extracting(Car::getPosition)
                .containsOnly(Position.valueOf(2));
    }


    /*
    @Test
    void inputWrongValueFail() {
       assertThatIllegalArgumentException()
               .isThrownBy(() -> RacingGame.rea(-1, "test1,test2"))
               .withMessageMatching("시도 횟수는 " + INPUT_MIN_ROUND + "보다 커야합니다.");
    }

    @Test
    @DisplayName("횟수가 " + GAME_END_ROUND + "이면 게임종료")
    void timeZeroThenGameOver() {
        RacingGame game = RacingGame.ready(0, SAMPLE_NAMES);
        assertThat(game.isGameOver()).isTrue();
    }

    @Test
    @DisplayName("횟수가 " + GAME_END_ROUND + "이 아닐 시 게임진행")
    void timeNoZeroThenGameOver() {
        RacingGame game = RacingGame.ready(3, SAMPLE_NAMES);
        assertThat(game.isGameOver()).isFalse();
    }*/
}