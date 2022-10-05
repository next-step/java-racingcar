package step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class WinnerTest {

    private String input = "pobi,crong,honux";

    @Test
    @DisplayName("winner 생성 테스트")
    void createWinnerTest() {
        Separation separation = new Separation();
        Winner winner = new Winner(new GameInfo(separation.nameSeparation(input), 5));
        assertThat(winner.getWinnerList().size()).isEqualTo(3);
    }

}