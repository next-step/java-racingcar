package racingcar.car.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalStateException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarGameManagerTest {

    final int playCount = 4;
    CarGameManager gameManager;

    @BeforeEach
    void setUp() {
        gameManager = new CarGameManager(new String[] {"a", "b"}, playCount);
    }

    @Test
    @DisplayName("게임 카운트가 종료된 후 게임을 실행하면 예외를 던진다.")
    void race_executeAfterGameEnd_ThrowException() {
        for (int i = 0; i < playCount; i++) {
            gameManager.race();
        }
        assertThatIllegalStateException().isThrownBy(() -> gameManager.race());
    }

    @Test
    @DisplayName("게임이 종료되면 false 를 반환한다.")
    void isRunning_whenGameEnds_ReturnFalse() {
        for (int i = 0; i < playCount; i++) {
            assertThat(gameManager.isRunning()).isTrue();
            gameManager.race();
        }
        assertThat(gameManager.isRunning()).isFalse();
    }
}