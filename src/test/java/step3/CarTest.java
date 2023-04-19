package step3;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    void car_init_location() {
        assertThat(new Car("name").getLocation()).isEqualTo(0);
    }
}
