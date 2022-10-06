package step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.view.Separation;

import static org.assertj.core.api.Assertions.assertThat;

class WinnerTest {

    private Separation separation = new Separation();
    private String input = "pobi,crong,honux";

    @Test
    @DisplayName("winner 생성 테스트")
    void createWinnerTest() {
        Winner winner = new Winner(new Cars(separation.nameSeparation(input)).getCarList());
        assertThat(winner.getWinnerList().size()).isEqualTo(3);
    }

}