package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GameNumbersTest {

    GameNumbers gameNumbers;

    @Test
    @DisplayName("다음 라운드로 진행하는지 테스트")
    void increaseRound() {
        int tryCounts = 5;
        int round = 0;
        gameNumbers = new GameNumbers(tryCounts, round);
        gameNumbers.increaseRound();

        assertThat(gameNumbers.getRound()).isEqualTo(++round);
    }
}