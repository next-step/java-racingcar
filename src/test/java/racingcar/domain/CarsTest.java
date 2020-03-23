package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    @DisplayName("자동차 대수를 입력하면 자동차 컬렉션을 생성할 수 있다")
    @Test
    public void newCarsWithNumberOfCars() {
        //given
        int numberOfCars = 5;
        Cars cars = new Cars(numberOfCars);

        //when & then
        assertThat(cars).isNotNull();
    }

    @DisplayName("자동차 컬렉션은 포함하고 있는 모든 자동차를 전진시킬 수 있다")
    @Test
    public void makeAllCarsToMove() {
        //given
        final int numberOfCars = 5; // 자동차 대수
        Cars cars = new Cars(numberOfCars);

        //when & then
        assertThat(cars.moveAllCar(() -> true)).isNotNull();
    }

}
