package step2;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    private static Car car = new Car(5);

    @ParameterizedTest
    @CsvSource(value = {"true:0:1", "true:1:2", "false:2:2", "true:3:3", "false:4:3"}, delimiter = ':')
    void go(boolean is, int turn, int count) {
        if (is) {
            car.ahead(count);
        }
        assertThat(car.moveCountSet.previousSetBit(turn+1)).isEqualTo(count);
    }
}