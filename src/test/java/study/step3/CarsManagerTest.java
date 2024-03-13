package study.step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.Model.Car;
import step3.Model.CarsManager;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsManagerTest {
    @Test
    @DisplayName("차량들의 위치를 반환하는 기능")
    void getCarsDistanceTest() {
        //given
        Car car1 = new Car(1);
        Car car2 = new Car(2);
        Car car3 = new Car(3);
        List<Car> cars = Arrays.asList(car1, car2, car3);
        CarsManager carsManager = new CarsManager(cars);

        //when
        List<Integer> expected = Arrays.asList(1, 2, 3);
        List<Integer> result = carsManager.getCarsPosition();

        //then
        assertThat(result).isEqualTo(expected);
    }
}
