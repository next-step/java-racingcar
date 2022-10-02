package RacingCar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CarTest {
    @Test
    @DisplayName("자동차 입력")
    void carInputTest() {
        Car car = new Car("Jason");
        assertThat(car.getName()).isEqualTo("Jason");
    }

    @ParameterizedTest
    @DisplayName("자동차 이름 테스트")
    @CsvSource(value = {"jason:true", "tomboy:false"}, delimiter = ':')
    void nameValidateTest(String input, boolean result) {
        boolean check = true;
        try {
            Validate.carNameCheck(input);
        } catch (Exception e) {
            check = false;
        }

        assertThat(check).isEqualTo(result);
    }

    @ParameterizedTest
    @DisplayName("자동차 이동 테스트")
    @CsvSource(value = {"3:1", "4:2"}, delimiter = ':')
    void move(int value, int result) {
        Car car = new Car("test");
        car.move(value);
        assertThat(car.getPosition()).isEqualTo(result);
    }
}
