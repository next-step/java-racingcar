package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    @DisplayName("게임에 참여할 자동차 이름들을 입력하면 자동차 컬렉션을 생성할 수 있다")
    @Test
    public void newCarsWithNumberOfCars() {
        //given
        String[] carNames = new String[]{"정원", "자바", "레이서"};

        Cars cars = new Cars(carNames);

        //when & then
        assertThat(cars).isNotNull();
    }

    @DisplayName("자동차 컬렉션은 포함하고 있는 모든 자동차를 전진시킬 수 있다")
    @Test
    public void makeAllCarsToMove() {
        //given
        String[] carNames = new String[]{"정원", "자바", "레이서"};
        Cars cars = new Cars(carNames);

        //when & then
        assertThat(cars.moveAllCar(() -> true)).isNotNull();
    }

}
