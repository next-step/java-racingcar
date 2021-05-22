package carracing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class CarTest {
    private Car car;

    @BeforeEach
    void setUp() {
        String carName = "Scar";
        car = new Car(carName);
    }

    @Test
    void CarNameTest() {
        assertThat(car.toString()).isEqualTo("Scar");
    }

    @ParameterizedTest
    @ValueSource(strings = {"SangkoooCar", "brotherCar", "sisterCar"})
    void nameCheckTest(String carName) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            car = new Car(carName);
        });
    }

    @Test
    void moveTest() {
        car.move(4);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void stopTest() {
        car.move(3);
        assertThat(car.getPosition()).isEqualTo(0);
    }
}
