package carracing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("자동차 경주의 자동차들을 위한 테스트")
class CarsTest {

    private static final int NUMBER_OF_CARS = 3;
    private static final int MOVABLE_POSITION_NUMBER_PER_MOVEMENT = 1;
    private static final int INITIATION_POSITION_NUMBER = 0;
    private static final int FIRST_MOVING_POSITION_NUMBER = INITIATION_POSITION_NUMBER + MOVABLE_POSITION_NUMBER_PER_MOVEMENT;

    @DisplayName("자동차들의 생성여부 확인")
    @Test
    void createCarsTest() {
        // when
        Cars cars = new Cars(NUMBER_OF_CARS);
        // then
        assertThat(cars).isNotNull();
        assertThat(cars.getCars()).hasSize(NUMBER_OF_CARS);
    }

    @DisplayName("자동차들의 이동이 가능한 경우, 이동했을 때 실제 이동하였는지 확인")
    @Test
    void checkMovableCarsTest() {
        // given
        Cars cars = new Cars(NUMBER_OF_CARS);
        // when
        cars.moveCars(() -> true);
        // then
        assertThat(cars.getCars())
                .extracting(Car::getPosition)
                .hasSize(NUMBER_OF_CARS)
                .extracting(CarPosition::getNumber)
                .containsOnly(FIRST_MOVING_POSITION_NUMBER);
    }

    @DisplayName("자동차들의 이동이 불가능 경우, 이동했을 때 실제 이동하였는지 확인")
    @Test
    void checkUnmovableCarsTest() {
        // given
        Cars cars = new Cars(NUMBER_OF_CARS);
        // when
        cars.moveCars(() -> false);
        // then
        assertThat(cars.getCars())
                .extracting(Car::getPosition)
                .hasSize(NUMBER_OF_CARS)
                .extracting(CarPosition::getNumber)
                .containsOnly(INITIATION_POSITION_NUMBER);
    }
}
