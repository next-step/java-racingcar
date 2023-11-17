package step4;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinnerTest {
    @Test
    void getWinnersTest() {
        Car pobi = new Car(3);
        Car crong = new Car(5);
        Car honux = new Car(10);
        List<Car> carList = List.of(pobi,crong,honux);

        ResultView resultView = new ResultView();
        Winners winners = new Winners();
        winners.getWinners(carList);
        resultView.printWinners(winners.getWinnerNames());
        assertThat(winners.getWinnerNames()).isEqualTo("honux");
    }
}
