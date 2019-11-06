package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingTest {

    @ParameterizedTest
    @CsvSource(value = {"5:1", "8:1"}, delimiter = ':')
    @DisplayName("전진 조건 테스트")
    void moveConditionTest(int conditionValue, int carPosition) {
        Car car = new Car("testcar");
        assertThat(car.move(conditionValue)).isEqualTo(carPosition);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:0", "3:0"}, delimiter = ':')
    @DisplayName("멈춤 조건 테스트")
    void stopConditionTest(int conditionValue, int carPosition) {
        Car car = new Car("testcar");
        assertThat(car.move(conditionValue)).isEqualTo(carPosition);
    }
}
