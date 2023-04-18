package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @DisplayName("random 값이 4이상인 경우 전진")
    @ParameterizedTest(name = "{displayName} {index} = 랜덤값: {0} -> 결과: {1}")
    @CsvSource(value = {"4:1", "5:1", "6:1", "7:1", "8:1", "9:1"}, delimiter = ':')
    void test2(int input, int result) {
        Car car = new Car();
        assertThat(car.move(input)).isEqualTo(result);
    }

    @DisplayName("random 값이 4미만인 경우 멈춤")
    @ParameterizedTest(name = "{displayName} {index} = 랜덤값: {0} -> 결과: {1}")
    @CsvSource(value = {"0:0", "1:0", "2:0", "3:0"}, delimiter = ':')
    void test1(int input, int result) {
        Car car = new Car();
        assertThat(car.move(input)).isEqualTo(result);
    }

}
