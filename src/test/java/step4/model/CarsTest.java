package step4.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    @DisplayName("자동차 리스트 정렬하기(포지션 내림차순)")
    @Test
    void arrangeCarTest(){
        Car car1 = new Car("car1",10);
        Car car2 = new Car("car2",3);
        Car car3 = new Car("car3",5);
        List<Car> list = new ArrayList<>();

        list.add(car1);
        list.add(car2);
        list.add(car3);

        Cars cars = new Cars(new CarsMethod());

        cars.makeCars(list.toArray(new Car[0]));

        cars.arrangeCars();

        assertThat(cars.getCarList()).containsExactly(car1,car3,car2);
    }
}
