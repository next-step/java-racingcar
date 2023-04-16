package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
class RacingCarGameTest {

    private RacingCarGame racingCarGame = new RacingCarGame();

    @Test
    @DisplayName("start 하면 우승자를 출력한다.")
    void start() {
        String input = "짱구,철수,맹구\n5\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        racingCarGame.start();

        List<String> winners = racingCarGame.getWinners();
        assertThat(winners).containsAnyOf("짱구", "철수", "맹구");
    }
}