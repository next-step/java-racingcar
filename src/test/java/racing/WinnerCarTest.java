package racing;

import org.junit.Test;
import racing.domain.RacingCar;
import racing.domain.WinnerCar;
import racing.view.ResultView;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class WinnerCarTest {
    private WinnerCar winnerCar = new WinnerCar();

    @Test
    public void 우승자_한명() {
        List<String> winners =  this.winnerCar.getWinners(
                Arrays.asList(new RacingCar("a", 1),
                        new RacingCar("i", 8))
        );
        ResultView.printWinner(winners);
        assertThat(winners.size(), is(1));
    }

    @Test
    public void 우승자_여러명() {
        List<String> winners =  this.winnerCar.getWinners(
                Arrays.asList(new RacingCar("a", 1),
                        new RacingCar("b", 5),
                        new RacingCar("c", 7),
                        new RacingCar("d", 5),
                        new RacingCar("e", 4),
                        new RacingCar("f", 3),
                        new RacingCar("g", 5),
                        new RacingCar("h", 7),
                        new RacingCar("i", 5))
        );
        ResultView.printWinner(winners);
        assertThat(winners.size(), is(2));
    }
}
