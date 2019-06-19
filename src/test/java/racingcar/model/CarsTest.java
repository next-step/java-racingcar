package racingcar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class CarsTest {
    private List<CarName> names;

    @BeforeEach
    void setUp() {
        names = Arrays.asList(CarName.valueOf("yong")
                , CarName.valueOf("pobi")
                , CarName.valueOf("crong")
                , CarName.valueOf("honux"));
    }

    @Test
    void Cars는_Car의_이름만으로_생성할_수_있다() {
        Cars cars = Cars.createWithNames(names);
        assertThat(cars).isInstanceOf(Cars.class);
    }

    @Test
    void Cars는_Car의_리스트로_생성할_수_있다() {
        List<Car> cars = new ArrayList<>();
        DrivingRule alwaysTrueRule = () -> true;

        for (CarName name : names) {
            Car car = Car.createWithDrivingRule(name, alwaysTrueRule);
            cars.add(car);
        }

        assertThat(Cars.create(cars)).isInstanceOf(Cars.class);
    }

    @Test
    void Cars에_속한_자동차_갯수를_확인한다() {
        Cars cars = Cars.createWithNames(names);

        assertThat(cars.size()).isEqualTo(names.size());
    }

    @Test
    void Cars는_여러대의_차를_움직일_수_있다() {
        Cars cars = Cars.createWithNames(names);
        List<CarInformation> informationOnCars = cars.move();

        assertThat(informationOnCars).hasSize(cars.size())
                .extracting("class")
                .containsOnly(CarInformation.class);
    }

    @Test
    void Cars에서_자동차들의_정보를_얻을_수_있다() {
        Cars cars = Cars.createWithNames(names);
        List<CarInformation> informationOnCars = cars.getInformationOnCars();

        assertThat(informationOnCars).hasSize(cars.size())
                .extracting("class")
                .containsOnly(CarInformation.class);
    }
}