package step3.logic;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @DisplayName("test for perfect Engine")
    @Test
    void perfectEngine() {
        Car car = new Car(Engine.PERFECT_ENGINE);
        car.run();
        assertThat(car.getCurrentPosition()).isEqualTo(1);
    }

    @DisplayName("test for broken Engine")
    @Test
    void brokenEngine() {
        Car car = new Car(Engine.BROKEN_ENGINE);
        car.run();
        assertThat(car.getCurrentPosition()).isEqualTo(0);
    }
}
