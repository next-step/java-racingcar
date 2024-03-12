package race;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    private Car car1;

    @BeforeEach
    void init() {
        car1 = new Car();
    }

    @Test
    void go_three_times() {
        car1.go();
        car1.go();
        car1.go();
        assertThat(car1.getMileage()).isEqualTo("---");
    }

    @Test
    void go_twice() {
        car1.go();
        car1.go();
        assertThat(car1.getMileage()).isEqualTo("--");
    }

    @Test
    void go() {
        car1.go();
        assertThat(car1.getMileage()).isEqualTo("-");
    }

}
