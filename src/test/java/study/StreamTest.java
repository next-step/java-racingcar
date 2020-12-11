package study;

import carrace.domain.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class StreamTest {

    private List<Car> carList;
    private Car car1;
    private Car car4;

    @BeforeEach
    void setUp() {
        car1 = new Car(8, "a");
        Car car2 = new Car(2, "b");
        Car car3 = new Car(1, "c");
        car4 = new Car(8, "d");
        Car car5 = new Car(2, "e");

        carList = Arrays.asList(car1, car2, car3, car4, car5);
    }

    @Test
    void maxTest() {
        //given
        //when
        Integer maxPos = carList.stream().map(Car::getPosition).max(Integer::compare).get();

        //then
        assertThat(maxPos).isEqualTo(8);
    }

    @Test
    void filterTest() {
        //given
        int max = 8;

        //when
        List<Car> carList = this.carList.stream()
                .filter(car -> car.getPosition() == max)
                .collect(Collectors.toList());

        //then
        assertThat(carList).contains(car1, car4);
    }
}
