package racingcar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.util.MovingGenerator;
import racingcar.util.NoMovingGenerator;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class CarsTest {

    private Names CAR_NAMES;

    @BeforeEach
    void setUp() {
        CAR_NAMES = Names.from("test1,test2,test3");
    }

    @Test
    @DisplayName("문자열의 쉼표(,)를 구분자로 하여 자동차 생성")
    void createOfString() {
        Cars cars = Cars.from(CAR_NAMES);
        assertThat(cars.getCars()).hasSize(3);
    }

    @Test
    @DisplayName("자동차들이 전진한다")
    void moveCar() {
        Cars cars = getCars();
        cars.move(new MovingGenerator());
        assertThat(cars.getCars()).
                extracting(Car::getPosition)
                .containsOnly(Position.valueOf(2));
    }

    @Test
    @DisplayName("자동차는 움직이지 않는다")
    void nonMoveCar() {
        Cars cars = getCars();
        cars.move(new NoMovingGenerator());
        assertThat(cars.getCars())
                .extracting(Car::getPosition)
                .containsOnly(Position.valueOf(1));
    }

    @Test
    @DisplayName("가장 많이 전진한 자동차를 반환한다")
    void winningResultACar() {
        Car winningCar = carOf("test2", 5);

        List<Car> carList = new ArrayList();
        carList.add(winningCar);
        carList.add(carOf("test", 1));
        carList.add(carOf("test3", 3));

        Cars cars = new Cars(carList);
        List<Car> result = cars.winningCars();

        assertThat(result).hasSize(1)
                .containsOnly(winningCar);
    }

    private Cars getCars() {
        return Cars.from(CAR_NAMES);
    }

    private Car carOf(String name, int position) {
        return new Car(name, Position.valueOf(position));
    }
}