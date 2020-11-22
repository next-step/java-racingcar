package racingcarwinner;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.Assert.assertTrue;

public class RoundTest {

    @Test
    @DisplayName("라운드 세팅이 제대로 되었는가?")
    public void setRoundTest(){
        Game game = Game.createGame("베니",3);
        assertTrue(game.getRound().equals(new Round(3)));
    }

}
