package RacingCar;

import RacingCar.domain.Car;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CarTest {
    @Test
    @DisplayName("자동차 입력")
    void carInputTest() {
        Car car = new Car("Jason", 1);
        assertThat(car.getName()).isEqualTo("Jason");
    }

    @ParameterizedTest
    @DisplayName("자동차 이름 테스트")
    @CsvSource(value = {"jason:true", "tomboy:false"}, delimiter = ':')
    void nameValidateTest(String input, boolean result) {
        boolean check = true;

        try {
            Car car = new Car(input, 1);
        } catch (Exception e) {
            check = false;
        }

        assertThat(check).isEqualTo(result);
    }

    @ParameterizedTest
    @DisplayName("자동차 이동 테스트")
    @CsvSource(value = {"false:1", "true:2"}, delimiter = ':')
    void move(boolean value, int result) {
        Car car = new Car("test", 1);
        car.move(value);
        assertThat(car.isSamePosition(result)).isTrue();
    }
}
