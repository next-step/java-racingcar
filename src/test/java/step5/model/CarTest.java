package step5.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    void check_car_initialization_and_Name() {
        assertThat(new Car("john").getName()).isEqualTo("john");
    }

    @Test
    void check_Car_distance() {
        assertThat(new Car("Kim").getDistance()).isEqualTo(0);
    }
}
