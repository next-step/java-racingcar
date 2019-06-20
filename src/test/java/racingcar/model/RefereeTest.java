package racingcar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.util.drivingStrategy.DrivingStrategy;
import racingcar.util.drivingStrategy.MockDrivingStrategy;

import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class RefereeTest {

    private Cars cars;

    @BeforeEach
    void setUp() {
        DrivingStrategy strategy = MockDrivingStrategy.getInstance();

        String[] names = {"pobi", "tobi", "sobi"};
        cars = new Cars(names, strategy);
        cars.resetPosition();
    }

    @Test
    @DisplayName("Car들의 position 중 max 값을 찾는다")
    void max() {
        assertThat(Referee.max(cars)).isEqualTo(1);

        cars.move();
        assertThat(Referee.max(cars)).isEqualTo(2);

        cars.move();
        assertThat(Referee.max(cars)).isEqualTo(3);
    }

    @Test
    @DisplayName("Car들 중에서 Winner를 찾는다.")
    void getWinnerFrom() {
        List<Car> carList = cars.getCars();
        Car pobi = carList.get(0);
        Car tobi = carList.get(1);

        pobi.move();
        assertThat(Referee.getWinnerFrom(cars)).isEqualTo("pobi");

        tobi.move();
        assertThat(Referee.getWinnerFrom(cars)).isEqualTo("pobi, tobi");
    }

}
