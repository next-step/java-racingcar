package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("레이싱게임 클래스 테스트")
class RacingGameTest {

    @Test
    @DisplayName("게임 초기화 테스트")
    void initRacingGameTest() {
        try {
            int carCount = 3;
            int round = 5;
            RacingGame racingGame = new RacingGame(carCount, round);
            Class<? extends RacingGame> clazz = racingGame.getClass();
            Field privateRoundField = clazz.getDeclaredField("round");
            privateRoundField.setAccessible(true);
            assertThat(privateRoundField.get(racingGame)).isEqualTo(round);
            //FIXME:carList size 호출해서 비교하는부분 추가
            Field privateCarListField = clazz.getDeclaredField("carList");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}