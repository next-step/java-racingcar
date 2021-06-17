package carracing;

import carracing.model.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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

    @DisplayName("차는 이름을 가진다.")
    @Test
    void CarNameTest() {
        assertThat(car.getName()).isEqualTo("Scar");
    }

    @DisplayName("차의 이름의 길이는 5자 미만이다.")
    @ParameterizedTest
    @ValueSource(strings = {"koCar", "jpCar", "cnCar"})
    void nameCheckTest(String carName) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            car = new Car(carName, 0);
        });
    }

    @DisplayName("차는 난수가 4이상일 때 움직인다.")
    @Test
    void moveTest() {
        car.move(4);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @DisplayName("차는 난수가 3이하일 때 멈춘다.")
    @Test
    void stopTest() {
        car.move(3);
        assertThat(car.getPosition()).isEqualTo(0);
    }
}
