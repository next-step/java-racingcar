package racingcarrefectoring;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import racingcarrefectoring.model.Name;
import racingcarrefectoring.model.Winner;

import static org.junit.Assert.assertTrue;

public class WinnerTest {

    @Test
    @DisplayName("우승자 객체가 잘 만들어지는가")
    public void createWinner(){
        Winner winner = new Winner(new Name("베니"));
        Name name = new Name("베니");
        assertTrue(winner.getName().equals(name));
    }
}
