package racingcarrefectoring;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

public class RoundsTest {

    @Test
    @DisplayName("경기들이 잘 생성되는가")
    public void createRounds(){
        Rounds rounds = Rounds.create(3);
        assertEquals(rounds.getRoundCount(),3);
    }
}
