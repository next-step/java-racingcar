package racingcarwinner;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class GameTest {

    Game game = new Game(3);

    @Test
    @DisplayName("4 이상일 때만 가능한가?")
    public void isOrAboveEnableNumberTest(){
        assertFalse(game.isOrAboveEnableNumber(3));
        assertTrue(game.isOrAboveEnableNumber(4));
    }
}
