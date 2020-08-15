package step5.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step5.streategy.MovementStrategy;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    Car car;

    @Test
    void check_car_initialization_and_Name() {
        assertThat(new Car("john").getName()).isEqualTo("john");
    }

    @ParameterizedTest
    @CsvSource(value = {"Kim, 0", "John, 0"})
    @DisplayName("초기 생성 후 내부에 거리가 0인지 확인")
    void check_Car_distance(String name, int expected) {
        assertThat(new Car(name).getDistance()).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"Jayce,1"})
    @DisplayName("앞으로 전진했을 때 차량 거리 확인")
    void increase_Car_distance_Test(String name, int expected) {
        car = new Car(name);
        car.goForward();
        assertThat(car.getDistance()).isEqualTo(expected);
    }

    @Test
    void move_Car_with_Strategy() {
        car = new Car("john");
        MovementStrategy movementStrategy = () -> true;
        car.moveWithStrategy(movementStrategy);
        assertThat(car.getDistance()).isEqualTo(1);
    }
}
