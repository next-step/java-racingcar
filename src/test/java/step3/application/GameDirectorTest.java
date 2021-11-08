package step3.application;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GameDirectorTest {

    private static final int END_ROUND = 0;

    @DisplayName("n대의 자동차가 각각 주어진 횟수 만큼 정지 or 전진 하는지 테스트")
    @Test
    void playGameTest() {
        //given
        int carCount = 5;
        int roundSize = 10;
        Round round = new Round(roundSize);
        GameDirector gameDirector = new GameDirector(carCount, round);

        //when
        gameDirector.playGame();

        //then
        assertThat(round).isEqualTo(new Round(END_ROUND));
    }

}
