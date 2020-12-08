package step5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step5.domain.Car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {

    Car car;

    @BeforeEach
    void setUp() {
        car = new Car("jack");
    }

    @Test
    @DisplayName("자동차 이름이 5자를 초과하면 IllegalArgumentException 발생")
    void length_IllegalArgumentException() {
        assertThatThrownBy(() -> {
            car = new Car("jackcoding");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("전진 조건에 만족하면 전진")
    void move() {
        car.move(()->true);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("전진 조건에 만족하지 않으면 스탑")
    void stop() {
        car.move(()->false);
        assertThat(car.getPosition()).isEqualTo(0);
    }

}
