package step3;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("레이싱 게임 테스트")
class RacingGameTest {

    @Test
    @DisplayName("게임 세팅 테스트")
    void gameSettingTest() {
        // given
        int carNumber = 4;
        int moveNumber = 2;
        // when
        RacingGame racingGame = RacingGame.of(carNumber, moveNumber);
        // then
        assertThat(racingGame.getCarNumber()).isEqualTo(carNumber);
        assertThat(racingGame.getMoveNumber()).isEqualTo(moveNumber);
        assertThat(racingGame.getCars().getCars().size()).isEqualTo(carNumber);
    }

}