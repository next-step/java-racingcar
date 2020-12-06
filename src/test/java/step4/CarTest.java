package step4;

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
    MovingStrategy movingStrategy;

    @BeforeEach
    void setUp() {
        car = new Car();
        movingStrategy = mock(RandomMovingStrategy.class);
    }

    @Test
    @DisplayName("전진 조건에 만족하면 전진")
    void move() {
        when(movingStrategy.isMove()).thenReturn(true);
        car.move(movingStrategy);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("전진 조건에 만족하지 않으면 스탑")
    void stop() {
        when(movingStrategy.isMove()).thenReturn(false);
        car.move(movingStrategy);
        assertThat(car.getPosition()).isEqualTo(0);
    }

}
