package carRacing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Random;

import static org.assertj.core.api.Assertions.*;

class CarTest {

    @ParameterizedTest
    @CsvSource(value = {"0:0", "1:0", "2:0", "3:0", "4:1", "5:1", "6:1", "7:1", "8:1", "9:1"}, delimiter = ':')
    @DisplayName("4 이상의 정수에 따라 Car 객체의 position 값이 증가하는지 테스트")
    void go(int randomNumber, int expectedPosition) {
        Car car = new Car(new Random() {
            @Override
            public int nextInt(int bound) {
                return randomNumber;
            }
        });

        assertThat(car.go()).isEqualTo(expectedPosition);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 10})
    @DisplayName("랜덤 숫자가 유효 범위를 벗어나면 예외가 발생하는지 테스트")
    void go(int randomNumber) {
        Car car = new Car(new Random() {
            @Override
            public int nextInt(int bound) {
                return randomNumber;
            }
        });

        assertThatIllegalStateException().isThrownBy(car::go).withMessageContaining("유효범위");
    }
}