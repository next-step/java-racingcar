package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @Test
    @DisplayName("자동차는 자신의 위치를 대시(-) 기호의 갯수로 표현할 수 있다.")
    public void carTest1() {
        Car car = new Car();
        assertThat(car.positionInfoString()).isEqualTo("-");
    }

    @ParameterizedTest
    @DisplayName("자동차는 기준이 되는 값보다 크거나 같을때만 움직인다.")
    @CsvSource(value = {"1:1", "2:1", "3:1", "4:2", "5:2", "6:2", "7:2", "8:2", "9:2"}, delimiter = ':')
    public void carTest2(int value, int expected) {
        Car car = new Car();
        car.goForward(value);
        assertThat(car.positionInfoString().length()).isEqualTo(expected);
    }
}
