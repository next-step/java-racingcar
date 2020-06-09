package step4;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class CarTest {

    @Test
    void create() {
        Car car = Car.of("peter");
        assertThat(car).isEqualTo(Car.of("peter"));
    }

    @Test
    void move() {
        Fuel fuel = new Fuel() {
            @Override
            public boolean isValid() {
                return true;
            }
        };
        Car peter = Car.of("peter");
        peter.move(fuel);
        assertThat(peter.getPosition()).isEqualTo(1);
    }
}