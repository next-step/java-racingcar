package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

public class WinnerExtractionTest {

    @DisplayName("가장 많이 움직인 자동차를 알 수 있다")
    @Test
    void getWinnersTest() {
        RacingGame racingGame = new RacingGame();
        WinnerExtraction winnerExtraction = new WinnerExtraction();
        List<Car> carList = new ArrayList<>();

        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        Car car3 = new Car("car3");

        carList.add(car1);
        carList.add(car2);
        carList.add(car3);

        car3.move(5);
        car3.move(5);
        car3.move(5);
        car3.move(5);
        car3.move(5);

        int maxPosition = 5;
        List<String> winners = winnerExtraction.getWinners(carList);

        for (String winner : winners) {
            assertThat(winner).isEqualTo("car3");
        }

    }

}
