package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

public class CarTest {

    @Test
    @DisplayName("처음 자동차의 위치는 0")
    void checkPosition() {
        Car car = new Car();
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @DisplayName("랜덤 값이 4이상일 때 자동차는 전진")
    @ParameterizedTest(name="랜덤값 {0}: 포지션 {1}")
    @CsvSource(value = {"3:0", "4:1"}, delimiter = ':')
    void moveCarAccordingToRandomValue(int randomValue, int position ) {
        Car car = new Car();
        car.move(randomValue);
        assertThat(car.getPosition()).isEqualTo(position);
    }
}
