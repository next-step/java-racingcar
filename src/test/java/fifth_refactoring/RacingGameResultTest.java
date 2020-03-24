package fifth_refactoring;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameResultTest {
    RacingGameResult racingGameResult = new RacingGameResult();

    @Test
    void setRankTest() {
        List<Car> carList = new ArrayList<Car>();

        Car car1 = new Car();
        car1.setCarName("test1");
        carList.add(car1);

        Car car2 = new Car();
        car2.setCarName("test2");
        car2.move();
        carList.add(car2);

        assertThat(racingGameResult.setRank(carList)).isEqualTo("test2");
    }
}
