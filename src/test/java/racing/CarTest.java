package racing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car();
    }

    @ParameterizedTest
    @CsvSource(value = {"true:4", "false:3", "true:8"}, delimiter = ':')
    public void checkMoveTest(boolean result, int value) {
        assertThat(car.checkMove(value)).isEqualTo(result);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    public void moveTest(int value) {
        for(int i = 0; i < value; i++) {
            car.move();
        }
        assertThat(car.getLocation()).isEqualTo(value);
    }
}