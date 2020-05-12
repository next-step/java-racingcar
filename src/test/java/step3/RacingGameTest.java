package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.RacingGame;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class RacingGameTest {

    @Test
    @DisplayName("이동 조건 랜덤 숫자 생성 테스트")
    void createRandomNumberTest() {
        Random random = new Random();
        int count = 100;

        for (int i = 0; i < count; i++) {
            assertThat(random.nextInt(10)).isBetween(0, 9);
        }
    }

    @Test
    @DisplayName("자동차 대수 음수 입력시 레이싱 게임 실패 테스트")
    void carCountInputMinusTest() {
        RacingGame racingGame = new RacingGame(-3, 4);

        assertThatIllegalArgumentException().isThrownBy(() -> {
            racingGame.start();
        }).withMessageContaining("carCount is not positive number");
    }

    @Test
    @DisplayName("회 수 음수 입력시 레이싱 게임 실패 테스트")
    void timeInputMinusTest() {
        RacingGame racingGame = new RacingGame(3, -4);

        assertThatIllegalArgumentException().isThrownBy(() -> {
            racingGame.start();
        }).withMessageContaining("time is not positive number");
    }

}
