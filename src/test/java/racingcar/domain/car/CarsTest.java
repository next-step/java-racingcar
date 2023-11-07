package racingcar.domain.car;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarsTest {

    private Cars cars;

    @BeforeEach
    void init() {
        List<Car> carList = Arrays.asList(new Car(), new Car(), new Car());
        this.cars = new Cars(carList);
    }

    @Test
    @DisplayName("생성한 Car의 갯수만큼 Cars에 생성된 carList에 추가된다.")
    void createCars() {
        assertThat(this.cars.getCars()).hasSize(3);
    }


    @Test
    @DisplayName("랜덤한 숫자중 4이상의 숫자가 나오면 자동차가 1칸 움직인다.")
    void moveCars_movable() {
        this.cars.move(() -> true);

        List<Car> carList = this.cars.getCars();
        boolean allMatchResult = carList.stream().allMatch(car -> car.getPosition() == 1);

        assertThat(allMatchResult).isTrue();
    }

    @Test
    @DisplayName("랜덤한 숫자중 3이하의 숫자가 나오면 자동차가 움직이지 않는다.")
    void moveCars_immovable() {
        this.cars.move(() -> false);

        List<Car> carList = this.cars.getCars();
        boolean allMatchResult = carList.stream().allMatch(car -> car.getPosition() == 0);

        assertThat(allMatchResult).isTrue();
    }

    @Test
    @DisplayName("get으로 가져온 불변 CarList를 clear 할 경우 오류가 발생한다.")
    void cleanCars() {
        List<Car> carList = this.cars.getCars();

        assertThatThrownBy(carList::clear)
                .isInstanceOf(UnsupportedOperationException.class);
    }
}