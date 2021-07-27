package race;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.model.Car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {

    Car car;
    @BeforeEach
    void setting() {
        car = new Car("test1");
    }

    @Test
    @DisplayName("car distance check Test")
    void carDistanceCheckTest() {
        car.go();
        assertThat(car.totalDistance()).isEqualTo(1);
    }

    @Test
    @DisplayName("car name check")
    void carNameCheck() {
        assertThatThrownBy(() -> {
            new Car("test123");
        }).isInstanceOf(IllegalArgumentException.class);
    }

}
