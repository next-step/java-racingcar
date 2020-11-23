package racingcarwinner;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

public class RoundsTest {

    @Test
    @DisplayName("라운드 리스트 생성이 잘 되는가")
    public void create(){
        Rounds rounds = Rounds.createRounds(1);
        assertTrue(rounds.equals(new Rounds(1)));
    }

    @Test
    @DisplayName("라운드를 제대로 가져오는가")
    public void getRound(){
        Rounds rounds = Rounds.createRounds(1);
        assertTrue(rounds.getRound(0).equals(new Round()));
    }

    @Test
    @DisplayName("라운드의 갯수를 제대로 가져오는가")
    public void getCount(){
        Rounds rounds = Rounds.createRounds(5);
        assertEquals(rounds.getCount(),5);
    }

}

