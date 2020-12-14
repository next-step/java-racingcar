package study.racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {

    Car car;

    @BeforeEach
    void setUp() {
        car = new Car("truly");

    }

    @Test
    @DisplayName("Car 클래스의 move 성공 테스트")
    void move_test() throws Exception {
        car.move(() -> true);

        Position position = car.getPosition();

        assertThat(new Position(1)).isEqualTo(position);
    }

    @Test
    @DisplayName("Car 클래스의 move 실패 테스트")
    void stop_test() throws Exception {
        car.move(() -> false);

        Position position = car.getPosition();

        assertThat(new Position(0)).isEqualTo(position);
    }
    
}
