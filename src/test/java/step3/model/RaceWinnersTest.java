package step3.model;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

class RaceWinnersTest {
    @Test
    void 우승자_생성_확인() {
        Car hwan2 = new Car("hwan2", new Movement(3));
        Car chan = new Car("chan", new Movement());
        Car ming = new Car("ming", new Movement(2));

        Cars cars = new Cars(Arrays.asList(hwan2, chan, ming));
        RaceWinners raceWinners = cars.getRaceWinners();

        assertThat(raceWinners.getWinnerNames()).hasSize(1);
        assertThat(raceWinners.getWinnerNames()).contains("hwan2");
    }
}