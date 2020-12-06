package step3.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.domain.Car;
import step3.domain.strategy.MovingStrategy;
import step3.domain.strategy.RandomMovingStrategy;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CarTest {

    Car car;

    @BeforeEach
    void setUp() {
        car = new Car();
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
