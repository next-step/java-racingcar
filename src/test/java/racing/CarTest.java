package racing;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CarTest {

    @Test
    @DisplayName("입력받은 수만큼 자동차 생성")
    void 자동차_생성() {
        assertThat(Car.createCars(5)).hasSize(5);
    }

    @ParameterizedTest(name = " 전진:{0}, 위치:{1}")
    @CsvSource(value = {"false:1", "true:2"}, delimiter = ':')
    void 행동시_전진여부_결과(boolean canProgress, int expectedPosition) {
        Car car = new Car();
        assertThat(car.active(canProgress)).isEqualTo(expectedPosition);
    }
}
