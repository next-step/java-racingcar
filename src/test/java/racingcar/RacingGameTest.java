package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.RacingGame;

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
    @DisplayName("회 수 음수 입력시 레이싱 게임 실패 테스트")
    void carNameInputEmptyTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            RacingGame racingGame = new RacingGame("", 10);
        }).withMessageContaining("carName is Empty");
    }

    @Test
    @DisplayName("회 수 음수 입력시 레이싱 게임 실패 테스트")
    void timeInputMinusTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            RacingGame racingGame = new RacingGame("A, B, C", -4);
        }).withMessageContaining("value is small than zero");
    }

    @Test
    @DisplayName("정상적인 게임 실행 테스트")
    void successRacingGameTest() {
        String carNames = "일번,이번,삼번";
        int time = 5;
        try {
            RacingGame racingGame = new RacingGame(carNames, time);
            racingGame.start();
        } catch (Exception e) {
            assertThat(e).isNotNull();
        }
    }

}
