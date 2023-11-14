package step3.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.domain.GameResult;

public class RacingCarServiceTest {
    @Test
    @DisplayName("입력값이 주어지면 레이싱 게임이 진행되고 결과를 반환한다.")
    void playRoundTest() {
        int carCount = 3;
        int roundCount = 5;
        GameResult gameResult = new GameResult();

        Assertions.assertThat(RacingCarService.playRound(carCount, roundCount)).isInstanceOf(gameResult.getClass());
    }
}
