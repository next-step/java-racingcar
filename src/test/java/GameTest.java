import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author jeongheekim
 * @date 3/18/24
 */
class GameTest {
    @Test
    @DisplayName("게임 시작하면 생선된 자동차 수는 1보다 크다.")
    void whenGameStartCarMoreThan1 () {
        Game game = new Game();
        game.start();
        Car[] cars = game.getCars();
        assertTrue(cars.length > 1);
    }
}
