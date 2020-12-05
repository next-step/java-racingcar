package step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CarTest {

    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car();
    }

    @Test
    @DisplayName("자동차 생성 테스트")
    void createCarTest() {
        assertThat(car.getDashboard()).isNotNull();
        assertThat(car.getDashboard().getMileage()).isEqualTo(0);
    }
}
