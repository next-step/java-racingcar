package racing.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {
    public static final String DELIMITER = ",";
    private Cars cars;

    @BeforeEach
    void setup() {
        cars = Cars.of("benz,bmw,audi".split(DELIMITER), () -> true);
    }

    @Test
    void number_of_cars() {
        assertThat(cars.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("movable 전략 리턴 값이 true 일 때 모든 차들 1칸 이동")
    void move_cars() {
        cars.moveCars();
        for (Car car : cars.getCars()) {
            assertThat(car.distance()).isEqualTo(1);
        }
    }

    @Test
    @DisplayName("movable 전략 리턴 값이 false 일 때 모든 차들 거리 변화 없음")
    void stop_cars() {
        cars = Cars.of("benz,bmw,audi".split(DELIMITER), () -> false);
        cars.moveCars();
        for (Car car : cars.getCars()) {
            assertThat(car.distance()).isEqualTo(0);
        }
    }
}
