package racingGame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingGame.racingGameException.IllegalInputRange;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class GameSettingTest {

    private GameSetting sampleSetting;

    @BeforeEach
    void setUp() {
        this.sampleSetting = GameSetting.of(3, 3);
    }

    @DisplayName("객체 생성 테스트")
    @Test
    void createGameSetting() {
        assertThatExceptionOfType(IllegalInputRange.class).isThrownBy(
                () -> {
                    GameSetting.of(-1, 3);
                }
        );
    }

    @DisplayName("현재 차량 댓수 확인")
    @Test
    void checkCars() {
        assertThat(this.sampleSetting.getNumCar()).isEqualTo(3);
    }

    @DisplayName("게임 종료상태 확인")
    @Test
    void checkFinishCondition() {
        assertThat(sampleSetting.gameFinished(3)).isEqualTo(false);
        assertThat(sampleSetting.gameFinished(4)).isEqualTo(true);
    }

}
