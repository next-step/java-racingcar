
import org.junit.jupiter.api.Test;
import racing.domain.Car;
import racing.domain.RacingGame;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;
import static racing.domain.RacingGame.SEPARATOR;


public class RacingGameTest {
    @Test
    public void findWinnerTest() {
        //given
        RacingGame racingGame = new RacingGame();
        String carString = "aaa,bbb,ccc,ddd,eee,fff";
        String[] carNameArray = carString.split(SEPARATOR);
        racingGame.makeCars(carNameArray);
        racingGame.getCars().get(0).move(5);

        //when
        List<String> winnerList = racingGame.findWinner();

        //then
        assertThat(winnerList.size()).isEqualTo(1);
    }
}
