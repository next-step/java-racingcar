package racing.core;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    void 리스트_생성(){
        int size = 3;
        List<Car> carList = Car.makeCarList(size);

        assertThat(carList).hasSize(size);
    }

    @Test
    void go_메소드(){
        int distance = 10;
        Car car = Car.builder()
                .distance(distance)
                .build();

        String expect = "-----------";
        assertThat(car.go()).isEqualTo(expect);
    }

    @Test
    void roll_메소드(){
        Car car = new Car();

        int rollResult = car.roll();

        Car expect = Car.builder().distance(rollResult).build();
        assertThat(car.getDistance()).isEqualTo(expect.getDistance());
    }
}
