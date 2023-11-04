package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


public class GameTest {

    private static int NUMBER_OF_CARS = 3;
    private static int NUMBER_OF_TRY = 5;

    @Test
    @DisplayName("게임 실행 시 주어진 수만큼 자동차가 생성된다")
    public void 게임_자동차_대수() {
        Game game = new Game(NUMBER_OF_CARS, NUMBER_OF_TRY);
        assertThat(game.cars()).hasSize(NUMBER_OF_CARS);
    }

}
