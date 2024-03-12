package race;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    void go_three_times() {
        Car car1 = new Car();
        car1.go();
        car1.go();
        car1.go();
        assertThat(car1.getMileage()).isEqualTo("---");
    }

    @Test
    void go_twice() {
        Car car1 = new Car();
        car1.go();
        car1.go();
        assertThat(car1.getMileage()).isEqualTo("--");
    }

    @Test
    void go() {
        Car car1 = new Car();
        car1.go();
        assertThat(car1.getMileage()).isEqualTo("-");
    }

}
