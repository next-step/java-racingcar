package racingcarrefectoring;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

public class WinnersTest {

    @Test
    @DisplayName("우승자 객체를 제대로 추가하고 가져오는가")
    public void addWinner(){
        Winners winners = new Winners();
        winners.addWinner("베니");
        assertTrue(winners.getWinner(0).Equals(new Winner("베니")));
    }
}
