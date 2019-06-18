package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.util.MovingGenerator;
import racingcar.util.NoMovingGenerator;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class CarsTest {

    @Test
    @DisplayName("문자열의 쉼표(,)를 구분자로 하여 자동차 생성")
    void createOfString() {
        String nameText = "test1,test2,test3";
        Cars cars = Cars.from(nameText);

        assertThat(cars.getCars())
                .hasSize(3)
                .extracting(Car::getName)
                .containsExactly("test1", "test2", "test3");
    }

    @Test
    @DisplayName("잘못된 문자열 입력으로 실패")
    void createOfStringFail() {
        String nameText = "test|test2$test3";
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Cars.from(nameText));
    }

    @Test
    @DisplayName("자동차들이 전진한다")
    void moveCar() {
        Cars cars = getCars();
        cars.moveAll(new MovingGenerator());
        assertThat(cars.getCars()).
                extracting(Car::getPosition).containsOnly(2);
    }

    @Test
    @DisplayName("자동차는 움직이지 않는다")
    void nonMoveCar() {
        Cars cars = getCars();
        cars.moveAll(new NoMovingGenerator());
        assertThat(cars.getCars())
                .extracting(Car::getPosition).containsOnly(1);
    }

    private Cars getCars() {
        return Cars.from("test1,test2,test3");
    }

    @Test
    @DisplayName("가장 많이 전진한 자동차를 반환한다")
    void winningResultACar() {
        Car winningCar = new Car("test2", 5);

        List<Car> carList = new ArrayList();
        carList.add(winningCar);
        carList.add(new Car("test", 1));
        carList.add(new Car("test3", 3));

        Cars cars = new Cars(carList);
        List<Car> result = cars.winningCars();

        assertThat(result).hasSize(1)
                .containsOnly(winningCar);
    }
}
