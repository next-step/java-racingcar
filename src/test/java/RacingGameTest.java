
import org.junit.jupiter.api.Test;
import racing.domain.RacingGame;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static racing.domain.RacingGame.SEPARATOR;


public class RacingGameTest {
    @Test
    public void findWinnerTest() {
        //given
        String carString = "aaa,bbb,ccc,ddd,eee,fff";
        String[] carNameArray = carString.split(SEPARATOR);
        RacingGame racingGame = new RacingGame(carNameArray);
        racingGame.getCars().get(0).move(5);

        //when
        List<String> winnerList = racingGame.findWinner();

        //then
        assertThat(winnerList.size()).isEqualTo(1);
    }
}
