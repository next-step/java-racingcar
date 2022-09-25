import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {

    @ParameterizedTest
    @CsvSource(value = {"0:0", "1:0", "2:0", "3:0", "4:1","5:1", "6:1", "7:1", "8:1", "9:1"}, delimiter = ':')
    void carMoveTest(int given, int expected) {
        Car car = new Car(1);
        car.move(given);

        assertThat(car.currentPosition).isEqualTo(expected);
    }

    @Test
    void carMoveFailedTest1() {
        assertThatThrownBy(() -> new Car(0).move(0))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("out of move count");
    }

    @Test
    void carMoveFailedTest2() {
        assertThatThrownBy(() -> new Car(1).move(10))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("not available value");
    }
}
