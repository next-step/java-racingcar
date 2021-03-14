package study.step5;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import study.step5.domain.Car;

/**
 * Car class Test
 */
public class CarTest {

    @DisplayName("자동차 이름 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"test1", "test2", "test"})
    void carNameTest(String carName) {
        Car car = new Car(carName);
        assertThat(car.getName()).isEqualTo(carName);
    }

    @DisplayName("자동차 이름 5차 초과(Exception) 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"test12", "test123"})
    void carNameExceptionTest(String carName) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Car(carName);
        }).withMessage("자동차 이름은 5자를 초과할 수 없습니다.");
    }

    @Test
    @DisplayName("자동차 위치 테스트")
    void getPosition() {
        Car car = new Car("test");
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @ParameterizedTest(name = "움직임 테스트")
    @CsvSource(value = {"1 : 1", "2 : 2", "3 : 3"}, delimiter = ':')
    void move(int distance, int expected) {
        Car car = new Car("test");
        car.move(distance);
        assertThat(car.getPosition()).isEqualTo(expected);
    }
}
