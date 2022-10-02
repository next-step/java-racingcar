package RacingCar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CarTest {
    @Test
    @DisplayName("자동차 입력")
    void carInputTest() {
        Car car = new Car("Jason");
        assertThat(car.getName()).isEqualTo("Jason");
    }

    @Test
    @DisplayName("자동차 대수 테스트")
    void initRacingTest() {
        Racing racing = new Racing("pj,jw", 5);
        assertThat(racing.getCarList().size()).isEqualTo(3);
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
