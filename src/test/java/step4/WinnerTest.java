package step4;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinnerTest {
    @Test
    void getWinnersTest() {
        Car pobi = new Car("pobi", 3);
        Car crong = new Car("crong", 5);
        Car honux = new Car("honux", 10);
        List<Car> carList = List.of(pobi, crong, honux);

        ResultView resultView = new ResultView();
        resultView.makeResultView(carList);

        Winners winners = new Winners();
        winners.getWinners(carList);
        assertThat(winners.getWinnerNames()).isEqualTo("honux");
    }
}
