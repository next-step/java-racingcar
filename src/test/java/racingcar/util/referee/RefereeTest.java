package racingcar.util.referee;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.util.drivingStrategy.MockDrivingStrategy;
import racingcar.util.refree.Referee;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class RefereeTest {

    private List<Car> cars;

    @BeforeEach
    void setUp() {

        Car car1 = new Car("pobi");
        Car car2 = new Car("tobi");
        Car car3 = new Car("sobi");

        car1.setDrivingStrategy(MockDrivingStrategy.getInstance());
        car2.setDrivingStrategy(MockDrivingStrategy.getInstance());
        car3.setDrivingStrategy(MockDrivingStrategy.getInstance());

        cars = Arrays.asList(car1, car2, car3);
    }

    @Test
    @DisplayName("Car들의 position 중 max 값을 찾는다")
    void max() {
        assertThat(Referee.max(cars)).isEqualTo(1);

        cars.get(0).move();
        assertThat(Referee.max(cars)).isEqualTo(2);

        cars.get(0).move();
        assertThat(Referee.max(cars)).isEqualTo(3);
    }

    @Test
    @DisplayName("Car들 중에서 Winner를 찾는다.")
    void getWinnerFrom() {
        cars.get(0).move();
        cars.get(0).move();
        assertThat(Referee.getWinnerFrom(cars)).isEqualTo("pobi");

        cars.get(1).move();
        cars.get(1).move();
        assertThat(Referee.getWinnerFrom(cars)).isEqualTo("pobi, tobi");
    }

}
