package study.step5;


import static org.assertj.core.api.AssertionsForInterfaceTypes.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import study.step5.domain.Car;
import study.step5.domain.Cars;

public class CarsTest {

    @ParameterizedTest(name = "자동차 추가 테스트")
    @ValueSource(strings = {"test1,test2,test3"})
    void addCarTest(String input) {
        String[] names = input.split(",");
        Cars cars = new Cars();
        for(int i=0; i<names.length; i++) {
            cars.addCar(new Car(names[i]));
        }
        assertThat(cars.getCars().size()).isEqualTo(3);
    }

    @Test
    @DisplayName("우승자 테스트")
    void findWinners() {
        Car test1 = new Car("test1", 3);
        Car test2 = new Car("test2", 3);
        Car test3 = new Car("test3", 2);

        List<Car> original = Arrays.asList(test1, test2, test3);
        Cars cars = new Cars(original);
        assertThat(cars.findWinners()).containsExactly(test1, test2);
    }
}
