package racing.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {
    private Car car;

    @BeforeEach
    void setUp() {
        this.car = new Car();
    }

    @DisplayName("자동차의 위치를 한 칸 증가시킬 수 있다.")
    @Test
    void carMoveTest() {
        car.move();

        assertThat(car.getPosition()).isEqualTo(1);
    }

}
