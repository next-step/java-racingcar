package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.util.MovingGenerator;
import racingcar.util.NoMovingGenerator;
import racingcar.util.NumberGenerator;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static racingcar.model.Car.DEFAULT_POSITION;

class CarsTest {

    @DisplayName("문자열의 쉼표(,)를 구분자로 하여 자동차 생성")
    @Test
    void createOfNamesString() {
        List<String> names = Arrays.asList("test1", "test2", "test3");
        Cars cars = Cars.from(names);
        assertThat(cars.getCars()).hasSize(3);
    }

    @DisplayName("자동차 이름 갯수가 2미만 일 시 에러")
    @Test
    void createOfOneNameThenFail() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Cars.from(Arrays.asList("test1")))
                .withMessageMatching("자동차는 2대이상이어야 합니다.");
    }

    @DisplayName("자동차들이 전진한다")
    @Test
    void moveCars() {
        Cars cars = createCars(new MovingGenerator());
        Cars move = cars.move();
        assertThat(move.getCars()).extracting(Car::getPosition)
                .containsOnly(DEFAULT_POSITION + 1);
    }

    @DisplayName("자동차들이 움직이지 않는다")
    @Test
    void nonMoveCars() {
        Cars cars = createCars(new NoMovingGenerator());
        cars.move();
        assertThat(cars.getCars()).extracting(Car::getPosition).containsOnly(DEFAULT_POSITION);
    }

    private Cars createCars(NumberGenerator numberGenerator) {
        List<Car> carList = Arrays.asList(Car.newInstance("test1"),
                                            Car.newInstance("test2"),
                                            Car.newInstance("test3"));
        return new Cars(carList, numberGenerator);
    }
}