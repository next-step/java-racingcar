package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @Test
    @DisplayName("자동차는 자신의 위치값을 제공할 수 있다.")
    public void carTest1() {
        Car car = new Car();
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @ParameterizedTest
    @DisplayName("자동차는 기준이 되는 값보다 크거나 같을때만 움직인다.")
    @CsvSource(value = {"-1:0", "0:1", "9:1", "10:0"}, delimiter = ':')
    public void carTest2(int value, int expected) {
        Car car = new Car();
        car.goForward(value);
        assertThat(car.getPosition()).isEqualTo(expected);
    }
}
