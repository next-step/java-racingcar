package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @DisplayName("random 값이 4이상일 경우에만 전진")
    @ParameterizedTest
    @CsvSource(value = {"0:0", "1:0", "2:0", "3:0", "4:1", "3:1", "6:2"}, delimiter = ':')
    void test1(int input, int result) {
        Car car = new Car();
        assertThat(car.move(input)).isEqualTo(result);
    }

}
