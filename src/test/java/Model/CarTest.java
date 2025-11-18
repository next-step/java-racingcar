package Model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

public class CarTest {
    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car(0);
    }

    @ParameterizedTest
    @CsvSource({
            "1, false",
            "2, false",
            "4, true",
            "5, true",
            "6, true",
            "9, true"
    })
    public void moveForwardCondition(int randomNumber, boolean expected) {
        assertThat(car.canMoveForward(randomNumber)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({
            "1, 0",
            "2, 0",
            "3, 0",
            "4, 1",
            "5, 1",
            "9, 1"
    })
    public void moveForward(int randomNumber, int expectedDiff) {
        int prevPosition = car.getPosition();
        car.tryMoveForward(randomNumber);

        assertThat(car.getPosition() - prevPosition).isEqualTo(expectedDiff);
    }
}
