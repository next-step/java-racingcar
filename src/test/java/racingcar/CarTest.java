package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.domain.Car;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @ParameterizedTest
    @DisplayName("자동차가 전진 가능한 조건인지 확인한다.")
    @CsvSource(value = {"4:true", "3:false"}, delimiter = ':')
    void isMovable_전진테스트(int number, boolean result) {
        Car car = new Car("test");
        boolean isMovable = car.isMovable(number);
        assertThat(isMovable).isEqualTo(result);
    }
}
