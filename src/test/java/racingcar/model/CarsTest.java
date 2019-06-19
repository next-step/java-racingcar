package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.util.MovingGenerator;
import racingcar.util.NoMovingGenerator;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class CarsTest {

    @DisplayName("문자열의 쉼표(,)를 구분자로 하여 자동차 생성")
    @Test
    void createOfString() {
        String names = "test1,test2,test3";
        Cars cars = Cars.from(names);
        assertThat(cars.getCars()).hasSize(3);
    }

    @DisplayName("구분자(,)로 문자열 잘랐을 때 자동차 1개미만인 경우 실패")
    @Test
    void createOfStringThenFail() {
        String names = "test1";
        assertThatIllegalArgumentException().isThrownBy(() -> Cars.from(names));
    }

    @DisplayName("자동차들이 전진한다")
    @Test
    void moveCars() {
        Cars cars = createCars();
        cars.move(new MovingGenerator());
        assertThat(cars.getCars()).
                extracting(Car::getPosition)
                .containsOnly(Position.valueOf(2));
    }

    @DisplayName("자동차들이 움직이지 않는다")
    @Test
    void nonMoveCars() {
        Cars cars = createCars();
        cars.move(new NoMovingGenerator());
        assertThat(cars.getCars())
                .extracting(Car::getPosition)
                .containsOnly(Position.valueOf(1));
    }

    @DisplayName("가장 많이 전진한 자동차를 반환한다")
    @Test
    void winningResult() {
        Car winningCar = carOf("test2", 5);
        List<Car> carList = Arrays.asList(winningCar,
                                            carOf("test", 1),
                                            carOf("test3", 3));
        Cars cars = new Cars(carList);

        WinningResult winningResult = cars.getWinningResult();

        assertThat(winningResult).isNotNull();
        assertThat(winningResult.getCars()).containsExactly(winningCar);

    }

    private Cars createCars() {
        return Cars.from("test1,test2,test3");
    }

    private Car carOf(String name, int position) {
        return new Car(name, Position.valueOf(position));
    }
}