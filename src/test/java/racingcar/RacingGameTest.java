package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    @Test
    @DisplayName("자동차 3대로 5번의 게임 테스트")
    void start_racingGameResult() {
        System.setIn(new ByteArrayInputStream("3\n5".getBytes()));
        RacingGame racingGame = new RacingGame();
        racingGame.start();
        assertThat(racingGame.participantCount()).isEqualTo(3);
        assertThat(racingGame.playCount()).isEqualTo(5);
    }
}
