package carRacing.car;

import carRacing.common.RandomGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CarsTest {

    RandomGenerator generator = mock(RandomGenerator.class);
    @Test
    @DisplayName("자동차의 이름은 중복될 수 없다.")
    void carNameMustBeUnique()  throws Exception {
        String name = "Harry";
        assertThatThrownBy(()->{
            Car car1 = Car.of(name);
            Car car2 = Car.of(name);
            Cars cars = Cars.of(new ArrayList<>());
            cars.addCar(car1);
            cars.addCar(car2);
        }).isInstanceOf(IllegalAccessException.class)
                .hasMessageContaining("이미 존재하는 이름입니다.");
    }

    @Test
    @DisplayName("우승자 리스트를 가져온다.")
    void shouldReturnWinnersNames() throws Exception {
        Car car1 = Car.of("1");
        Car car2 = Car.of("2");
        Cars cars = Cars.of(new ArrayList<>());
        cars.addCar(car1);
        cars.addCar(car2);

        when(generator.generate()).thenReturn(4);

        cars.forEach(car -> {
            car.updatePosition(generator.generate());
        });

        assertThat(cars.getWinners()).contains("1").contains("2");
        assertThat(cars.getWinners().size()).isEqualTo(2);
    }
}