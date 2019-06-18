package racingcar.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class CarsTest {
    @Test
    void Cars는_Car의_이름만으로_생성할_수_있다() {
        List<String> names = Arrays.asList("yong", "pobi", "crong", "honux");
        Cars cars = Cars.createWithNames(names);

        assertThat(cars).isInstanceOf(Cars.class);
    }

    @Test
    void Cars는_여러대의_Car로_생성할_수_있다() {
        List<Car> carList = new ArrayList<>();
        DrivingRule alwaysTrueRule = () -> true;
        DrivingRule alwaysFalseRule = () -> true;

        Car car1 = Car.createWithDrivingRule("yong", alwaysTrueRule);
        Car car2 = Car.createWithDrivingRule( "pobi", alwaysTrueRule);
        Car car3 = Car.createWithDrivingRule( "crong", alwaysFalseRule);

        carList.add(car1);
        carList.add(car2);
        carList.add(car3);

        Cars cars = Cars.create(carList);
        assertThat(cars).isInstanceOf(Cars.class);
    }

    @Test
    void Cars는_여러대의_차를_움직일_수_있다() {
        List<String> names = Arrays.asList("yong", "pobi", "crong", "honux");
        Cars cars = Cars.createWithNames(names);
        List<CarInformation> positions = cars.move();

        assertThat(positions.size()).isEqualTo(names.size());
    }
}