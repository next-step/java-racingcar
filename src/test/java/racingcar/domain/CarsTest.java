package racingcar.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class CarsTest {

    @Test
    void Cars생성시_성공() {
        // given
        final String[] carNames = new String[]{"pobi", "crong", "honux"};

        // when & then
        assertThatNoException().isThrownBy(() -> Cars.of(carNames));
    }
    
    @Test
    void 중복된이름을가진자동차들로생성시_실패_RuntimeException발생() {
        // given
        final String[] carNames = new String[]{"pobi", "pobi", "honux"};

        // when & then
        assertThatThrownBy(() -> Cars.of(carNames)).isInstanceOf(RuntimeException.class);
    }

    @Test
    void 가장높은position을가지는자동차를선택할때_성공() {
        // given
        final String[] carNames = new String[]{"pobi", "crong", "honux"};
        final Cars cars = Cars.of(carNames);
        final Car car = cars.getCars().get(0);
        car.moveForward();

        // when
        List<Car> maxPositionCars = cars.findMaxPositionCars();

        // then
        assertThat(maxPositionCars).hasSize(1).contains(car);
    }
}
