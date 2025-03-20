package step4.racingCar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step4.racingCar.domain.Car;
import step4.racingCar.domain.Cars;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.*;

class CarsTest {
    @Test
    void generateCars() {
        String[] names = {"yeo", "jin", "yu"};
        Cars cars = Cars.generateCars(Arrays.asList(names));
        assertThat(cars.getCars()).hasSize(3);
    }

    @Test
    @DisplayName("자동차를 입력받지 않을 경우 exception")
    void negativeCars() {
        String[] names = {};
        assertThatThrownBy(() -> Cars.generateCars(Arrays.asList(names))).isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("우승자가 input 값 안에 있는지 확인")
    void winners() {
        //given
        String[] names = {"yeo", "jin", "yu"};
        Cars cars = Cars.generateCars(Arrays.asList(names));

        //when
        cars.move();
        List<Car> winCars = cars.winners();
        List<String> winners = winCars.stream().map(Car::getName).collect(Collectors.toList());

        //then
        assertThat(winners).containsAnyOf("yeo", "jin" , "yu");
    }
}
