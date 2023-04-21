package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.domain.Car;
import racingcar.domain.CarMovingStrategy;

import static org.assertj.core.api.Assertions.*;

public class CarTest {

    private Car car;

    @BeforeEach
    public void beforeEach() {
        car = new Car();
    }

    @Test
    @DisplayName("move 메소드 확인")
    public void moveTest() {
        car.move(new CarMovingStrategy());
        assertThat(car.getPosition()).isBetween(0, 1);
    }
}
