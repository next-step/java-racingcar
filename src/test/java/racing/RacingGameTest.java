package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("레이싱게임 클래스 테스트")
class RacingGameTest {

    @Test
    @DisplayName("round를 입력받아 생성된 RacingGame의 private round 필드 값을 확인하는 테스트")
    void racingGameConstructorTest() {
        try {
            int carCount = 3;
            int round = 5;
            RacingGame racingGame = new RacingGame(carCount, round);

            Class<? extends RacingGame> clazz = racingGame.getClass();
            Field privateRoundField = clazz.getDeclaredField("round");
            privateRoundField.setAccessible(true);
            assertThat(privateRoundField.get(racingGame)).isEqualTo(round);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("playGame 메소드의 실행 결과를 확인할 수 있는 필드에 접근할 수 없어 테스트 할 수 없는 테스트")
    void playGameTest() {
        RacingGame racingGame = new RacingGame(3, 4);
        racingGame.playGame();
    }


}