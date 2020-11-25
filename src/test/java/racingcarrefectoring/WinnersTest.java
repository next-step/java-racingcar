package racingcarrefectoring;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import racingcarrefectoring.model.Name;
import racingcarrefectoring.model.Winner;
import racingcarrefectoring.model.Winners;

import static org.junit.Assert.assertTrue;

public class WinnersTest {

    @Test
    @DisplayName("우승자 객체를 제대로 추가하고 가져오는가")
    public void addWinner(){
        Winners winners = new Winners();

        winners.addWinner(new Name("베니"));
        assertTrue(winners.getWinner(0).equals(new Winner(new Name("베니"))));
    }
}
