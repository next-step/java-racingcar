package step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.domain.Car;
import step3.view.ResultView;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingTests {

    Car car;
    ResultView resultView;

    @BeforeEach
    public void setUp() {
        car = new Car();

    }

    @DisplayName("랜덤 값이 4이상인 경우")
    @Test
    public void inputRandomValueTest() {
        assertThat(car.move(6)).isEqualTo(1);
    }

    @DisplayName("랜덤 값이 4미인 경우")
    @Test
    public void howAdvancedCar() {
        assertThat(car.move(3)).isEqualTo(0);
    }
}
