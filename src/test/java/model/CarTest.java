package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

public class CarTest {
    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car(0);
    }

    @DisplayName("난수에 따라 자동차는 전진 혹은 정지한다.")
    @ParameterizedTest
    @CsvSource({
            "1, 0",
            "3, 0",
            "4, 1",
            "9, 1"
    })
    public void moveForward(int randomNumber, int expected) {
        car.tryMoveForward(randomNumber);
        assertThat(car.getPosition()).isEqualTo(expected);
    }
}
