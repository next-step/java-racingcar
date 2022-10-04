package racing.core;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    void 자동차_리스트_생성(){
        int size = 3;
        List<Car> carList = Car.makeCarList(size);

        assertThat(carList).hasSize(size);
    }

    @Test
    void 자동차_go_메소드(){
        int distance = 10;
        Car car = Car.builder()
                .distance(distance)
                .build();

        assertThat(car.go()).isEqualTo("----------");
    }
}
